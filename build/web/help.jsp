<%-- 
    Document   : help
    Created on : 22 févr. 2022, 12:45:59
    Author     : Manon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aide</title>
        <link rel="stylesheet" href="ressources/css/help_look.css" >
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
                
                
                
                
                //New game asked
                if (content!==null && content === "A"){
                    document.getElementById('givenanswer').value =content;
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/helpA.mp3');
                    audioSuccess.play();
                    
                    var delayInMilliseconds = 9000; //8 seconds

                        setTimeout(function() {
                            document.end_of_screen.submit();
                            
                            }, delayInMilliseconds);
                    
                }
                //Help page requested
                else{
                    if(content!==null && content!=='A'){
                            alert("Essayez de montrer le qr code correspondant à A si vous voulez lancer une partie");
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
        
        <form name="end_of_screen" action="aide" method="post"  >
            <input type="hidden" id ="givenanswer" name="result"  />
            
        </form>
        <div class="helpredirect"><div class="idred">Lancer une partie  ?</div></div>
        <div class="imgcont imgA" >
                <img src="ressources/img/signA.png" alt="signA">   
            </div>
        <div class="title"> Aide</div>
            
       
        <iframe
            class="pdfviewer"
            src="ressources/SilverOlympics_Guide_Utilisateur.pdf"
            >
                
        </iframe>
    </body>
</html>
