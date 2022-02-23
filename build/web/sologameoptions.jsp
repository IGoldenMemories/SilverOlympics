<%-- 
    Document   : sologameoptions
    Description: Display the pop-up that allows user to choose a solo game's  options  
    Created on : 28-nov.-2021, 16:01:51
    Author     : Manon Michaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partie Solo</title>
        <link rel="stylesheet" href="ressources/css/sologame_panel.css" >
        <script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.js'></script>
    </head>
    <body>
        
        <video id="preview" class="webcam_output"></video>
        <div class="displayansw" id="choice"> Vous avez sélectionné : <div  id="chosenanswer"></div></div>
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var hideVideo = document.getElementsByClassName("webcam_output")[0];
            hideVideo.style.display = "none";
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		//alert(content);
                
                document.getElementById('chosenanswer').innerHTML =content;
               
                
                
                //Options approved
                if (content!==null && content === "A"){
                    document.getElementById("choice").style.display = "block";
                    document.getElementById('givenanswer').value ="Newgame";
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                    audioSuccess.play();
                    
                    var delayInMilliseconds = 9000; //8 seconds

                        setTimeout(function() {
                            document.end_of_screen.submit();
                            
                            }, delayInMilliseconds);
                    
                }
                //Help page requested
                else{
                    if(content!==null && content=== "B"){
                        document.getElementById("choice").style.display = "block";
                        document.getElementById('givenanswer').value ="Help";
                        
                        //play audio with out html audio tag
                        var audioSuccess = new Audio('ressources/audio/ChoixBindex.mp3');
                        audioSuccess.play();
                        var delayInMilliseconds = 9000; //8 seconds

                        setTimeout(function() {
                            document.end_of_screen.submit();
                            
                            }, delayInMilliseconds);
                        
                    }
                    
                }
                
                
            });
            Instascan.Camera.getCameras().then(function (cameras){
		if(cameras.length>0){
                    scanner.start(cameras[0]);
                    $('[name="options"]').on('change',function(){
			if($(this).val()===1){
                            if(cameras[0]!==""){
				scanner.start(cameras[0]);
                            }
                            else{
				alert('No Front camera found!');
                            }
			}
                        else if($(this).val()===2){
                            if(cameras[1]!==""){
				scanner.start(cameras[1]);
                            }
                            else{
				alert('No Back camera found!');
                            }
			}
                    });
		}
                else{
                    console.error('No cameras found.');
                    alert('No cameras found.');
		}
            }).catch(function(e){
		console.error(e);
		//alert(e);
                });
        </script> 
        <div class="options">
            <div class="titreoption" >Options de la partie: </div>
            <br>
            
            <div id="chosenanswer"></div>
            
            <form method="post" action="jeusolooptions">
                
                <hr>
               
                <div class="titrechoix"> Sélectionnez les thèmes des questions de la partie: </div> 
                <br>
                <select name="themes" size=5 multiple>
                    <option class="history" name="history_button" value ="Histoire">Histoire</option>
                    <option class="sport" name="sport_button" value="Sport">Sport</option>
                    <option class="sciences" name="sciences_button" value ="Nature">Nature</option>  
                    <option class="geo" name="geo_button" value="Geographie">Géographie</option> 
                    <option class="language" name="language_button" value="Litterature">Littérature</option>  
                </select>
                <br>
                <input id="okoption" class="gamelaunchbutton" type="submit" value="Lancer la partie"  />
                <br>
                <br>
                <hr>
                <div class="titrechoix">Ou</div> 
                <hr>
                <div class="titrechoix">  Choisissez d'avoir des questions de thèmes aléatoires: </div>
                <br>
                <input type="submit" class="random"  name="random_button" value="Aléatoire"> 

            </form>
           
        </div>
        
    
    
        
        
    </body>
</html>
