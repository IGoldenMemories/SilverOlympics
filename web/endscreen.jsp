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
            //chooses randomly one of the success audio
            var audio_src = [],index = 0;
            audio_src[0] = "ressources/audio/gymno_three.mp3";
            audio_src[1] = "ressources/audio/arabes_one.mp3";
           
            index = Math.floor(Math.random() * audio_src.length);

            //play audio with out html audio tag
            var audioSuccess = new Audio(audio_src[index]);
            audioSuccess.play();
            
            
            scanner.addListener('scan',function(content){
		alert(content);
                
                
                if(content!==null && content==="A"){
                    audioSuccess.pause();
                    document.getElementById("givenanswer").value = "A";
                }
                else{
                    if(content!==null && content==="B"){
                        audioSuccess.pause();
                        document.getElementById("givenanswer").value = "B";
                    }
                    else{
                        if(content!==null && content==="C"){
                            audioSuccess.pause();
                            document.getElementById("givenanswer").value = "C";
                            //play audio with out html audio tag
                        var audioSuccess = new Audio('ressources/audio/ChoixCendscreen.mp3');
                        audioSuccess.play();
                        
                        var delayInMilliseconds = 7000; //7 seconds

                        setTimeout(function() {
                            
                            document.next_screen_choice.submit();
                            }, delayInMilliseconds);
                        }
                        else{
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
        <h1>Félicitation votre score est de :</h1>
        <div class="scoredisplay"> ${score} </div>
        <form name="next_screen_choice" action="ecranfinpartie" method="post" >
            Voulez-vous recommencer une partie ?
            <hr>
            Avec les mêmes options? 
            <div class="imgcontainer">
                <img src="ressources/img/signA.png">
            </div>
            
            <hr>
            Ou 
            Avec des options différentes ?
            <div class="imgcontainer">
                <img src="ressources/img/signB.png">
            </div>
            <hr>
            Souhaitez vous plutôt revenir au menu principal
            <div class="imgcontainer">
                <img src="ressources/img/signC.png">
            </div>
            <input type="hidden" id ="givenanswer" name="result" />
            
        </form>
        <div id="chosenotp"> </div>
        
        
        
        
    </body>
</html>
