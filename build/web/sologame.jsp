<%-- 
    Document   : sologame
    Created on : 1 déc. 2021, 14:34:27
    Author     : Manon Michaux 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partie solo</title>
        <link rel="stylesheet" href="ressources/css/sologamescreen.css" >
        <script>
            
            function displaytimer() {
                 document.getElementById('timerblock').style.display = "block";
            }
            var seconds=60;
            var timer;
            function countdown() {
                if(seconds < 60) {
                    document.getElementById("timernbr").innerHTML = seconds;
                }
                if (seconds >0 ) {
                    seconds--;
                } 
                else {
                    clearInterval(timer);
         
                }
            }
            if(!timer) {
                timer = window.setInterval(function() {
                countdown();
                    }, 1000);
                }
             
            
            document.getElementById("timer").innerHTML="1:00"; 
            </script>
        
        
    </head>
    <body>
        <div id="timerblock"  style="display:none;"  > 
            Temps restant: <div id="timernbr"> </div>
        </div>
        <div class="scoreblock"> Score: </div>
        <button  onClick="displaytimer()"> Cliquer ici pour tester le countdown </button>
        <video id="preview"></video>
        
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		alert(content);
		//window.location.href=content;
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
            })//.catch(function(e){
		//console.error(e);
		//alert(e);
                //});
        </script> 
        </br>
        <div class="question"> Question <div id="numquestion"> </div> :
        </div> </br>
        <div class="answers answerA">  A  </div> 
        <div class="answers answerB">  B  </div></br>
        <div class="answers answerC">  C  </div> 
        <div class="answers answerD">  D  </div> 
           
       
    </body>
</html>