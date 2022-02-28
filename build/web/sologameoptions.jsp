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
        
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var hideVideo = document.getElementsByClassName("webcam_output")[0];
            hideVideo.style.display = "none";
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		//alert(content);
                
                document.getElementById('chosenanswer').innerHTML =content;
                atheme = '${AthemeMapping}';
                btheme = '${BthemeMapping}';
                ctheme = '${CthemeMapping}';
                dtheme = '${DthemeMapping}';
                etheme = '${EthemeMapping}';
                ftheme = '${FthemeMapping}';
                
                
                
                
                if(atheme!==null && content!==null && content=== "A"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =atheme;
                        
                    //plays audio without html audio tag
                    //REPLACE THE AUDIO FILE IF YOU DECIDE TO CHANGE THE THEME CORRESPONDING TO THE A QR CODE
                    var audioSuccess = new Audio('ressources/audio/randomtheme.mp3');
                    audioSuccess.play();
                    alert(atheme); 
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
                
                //History was chosen (with current themes settings)
                if (btheme!==null && content!==null && content === "B"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value = btheme;
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
                //Sciences was chosen (with current themes settings)
                if (ctheme!==null && content!==null && content === "C"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =ctheme;
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
                //Geo was chosen (with current themes settings)
                if (dtheme!==null && content!==null && content === "D"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =dtheme;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/geotheme.mp3');
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
                //Sport was chosen (with current themes settings)
                if (etheme!==null && content!==null && content === "E"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =etheme;
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
                //Language was chosen(with current themes settings)
                if (ftheme!==null && content!==null && content === "F"){
                    document.getElementById('choice').style.display = "block";
                    document.getElementById('givenanswer').value =ftheme;
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
        <div class="titreoption" >Options de la partie: </div>
        <div class="options">
            
           
            <form method="post" action="jeusolooptions">
                
                <div class="titrechoix"> Sélectionnez les thèmes des questions de la partie: </div> 
                <br>
                
                <div class="img_container">
                    <img src="ressources/img/signB.png" alt="signB" class="img_item">   
                    
                    <img src="ressources/img/signC.png" alt="signC" class="img_item">   
                    
                    <img src="ressources/img/signD.png" alt="signD" class="img_item">   
                    
                    <img src="ressources/img/signE.png" alt="signE" class="img_item">   
                    
                    <img src="ressources/img/signF.png" alt="signF" class="img_item">   
                    
                </div>
                <div class="img_container"> 
                    <div class="titreopt"> ${BthemeMapping} </div> 
                    <div class="titreopt"> ${CthemeMapping} </div> 
                    <div class="titreopt"> ${DthemeMapping} </div> 
                    <div class="titreopt"> ${EthemeMapping} </div> 
                    <div class="titreopt"> ${FthemeMapping} </div> 
                    
                </div>
                <hr>
                <br>
                <div class="titrechoix">  Choisissez d'avoir des questions de thèmes aléatoires: </div>
                <div class="random">
                    <img src="ressources/img/signA.png" alt="signA">   
                </div>
                <div class="titrechoix"> ${AthemeMapping} </div>

            </form>
            
        </div>
                <form name="end_of_screen" action="jeusolooptions" method="post"  >
                <input type="hidden" id ="givenanswer" name="result"  />
            </form>
  </body>
</html>
