<%-- 
    Document   : endscrren
    Created on : 20 févr. 2022, 14:36:15
    Author     : Manon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecran de fin de partie</title>
        <link rel="stylesheet" href="ressources/css/endscreenlook.css" >
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
                
                
                if(content!==null && content==="A"){
                    
                    document.getElementById("givenanswer").value = "A";
                    var audioSuccess = new Audio('ressources/audio/ChoixAendscreen.mp3');
                    audioSuccess.play();
                        
                    var delayInMilliseconds = 7000; //7 seconds

                    setTimeout(function() {
                        document.next_screen_choice.submit();
                    }, delayInMilliseconds);
                }
                
                else{
                    if(content!==null && content==="B"){
                        
                        document.getElementById("givenanswer").value = "B";
                        var audioSuccess = new Audio('ressources/audio/ChoixBendscreen.mp3');
                        audioSuccess.play();
                        
                        var delayInMilliseconds = 8000; //7 seconds

                        setTimeout(function() {
                            
                            document.next_screen_choice.submit();
                        }, delayInMilliseconds);
                    }
                    
                    
                    if(content!==null && content==="C"){
                            
                            document.getElementById("givenanswer").value = "C";
                            //play audio with out html audio tag
                        var audioSuccess = new Audio('ressources/audio/ChoixCendscreen.mp3');
                        audioSuccess.play();
                        
                        var delayInMilliseconds = 8000; //7 seconds

                        setTimeout(function() {
                            
                            document.next_screen_choice.submit();
                            }, delayInMilliseconds);
                        }
                    else{
                        if(content!==null){
                            alert("Essayez de montrer le qr code correspondant à A B ou C plutôt");
                        }
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
                        else if((this).val()===2){
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
            
            <div class="titreoption" >Félicitation votre score est de :</div>
            <div class="scoredisplay"> ${score} </div>
            
            <div class="titreopt"> Voulez-vous recommencer une partie ? </div>
            <div class="optcont">
                <div class="img_container">
                    <div class="titreopt"> Avec les mêmes options?  </div> 
                    <br>
                    <img src="ressources/img/signA.png">
                </div>
                <div class="img_container">
                    <div class="titreopt"> Avec des options différentes ?  </div> 
                    <br>
                    <img src="ressources/img/signB.png">
                </div>  
            </div>
            <hr>
            
            <div class="titreopt"> Souhaitez vous plutôt revenir au menu principal </div>
            <div class="imgcontainer">
                <img src="ressources/img/signC.png">
            </div>
            
        </div>
        <form name="next_screen_choice" action="ecranfinpartie" method="post" >
            <input type="hidden" id ="givenanswer" name="result" />
            
        </form>
 
    </body>
</html>
