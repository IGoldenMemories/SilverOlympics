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
                var atheme = '${AthemeMapping}';
                
                //History was chosen
                if (content!==null && content === "history"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/historytheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 7000; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                }
                //Sport was chosen
                if (content!==null && content === "sport"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/sporttheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 7000; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                }
                //Language was chosen
                if (content!==null && content === "language"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/languagetheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 9000; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                }
                //Sciences was chosen
                if (content!==null && content === "sciences"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/sciencestheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 7500; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                }
                //Geo was chosen
                if (content!==null && content === "geo"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/geotheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 8000; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                }
                
                if(atheme!==null && content!==null && content=== "A"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =atheme;
                        
                    //play audio without html audio tag
                    //REPLACE THE AUDIO FILE IF YOU DECIDE TO CHANGE THE THEME CORRESPONDING TO THE A QR CODE
                    var audioSuccess = new Audio('ressources/audio/randomtheme.mp3');
                    audioSuccess.play();
                    var delaytolaunchmsg = 4000;//4seconds
                    setTimeout(function() {
                            var audioSuccess = new Audio('ressources/audio/Gamelaunch.mp3');
                            audioSuccess.play();
                    
                            var delayInMilliseconds = 8000; //8 seconds
                    
                            setTimeout(function() {
                                document.end_of_screen.submit();
                            
                                }, delayInMilliseconds);
                            
                            }, delaytolaunchmsg);
                    
                    
                    
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
           
            <form method="post" action="jeusolooptions">
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
                <br>
                <hr>
                <div class="titrechoix">Ou</div> 
                <hr>
                <div class="titrechoix">  Choisissez d'avoir des questions de thèmes aléatoires: </div>
                <br>
                <input type="submit" class="random"  name="random_button" value="Aléatoire"> 

            </form>
            <form name="end_of_screen" action="jeusolooptions" method="post"  >
                <input type="hidden" id ="givenanswer" name="result"  />
            </form>
        </div>
        
    
    
        
        
    </body>
</html>
