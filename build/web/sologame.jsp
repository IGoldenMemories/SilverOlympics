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
        <script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.js'></script>      
    </head>
    <body>
        <script type="text/javascript" src="ressources/js/sologamescript.js"></script>  
        <!<!-- Zone where the timer is displayed if the corresopnding checkbox has been checked in options panel (previous page) -->
        <div id="timerblock"  style="display:none;"  > 
            Temps restant: <div id="timernbr"> </div>
        </div>
        <div class="scoreblock"> Score: ${score} </div>
        <button  onClick="displaytimer()"> Cliquer ici pour tester le countdown </button>
        chosen options:
        ${timer}
        ${themeschoice}
        
        <video id="preview" class="webcam_output"></video>
        
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		alert(content);
                //HAD A DIV AND FILL IT WITH THE content (WHAT'S READ BY THE SCANNER 
		//window.location.href=content;
                document.getElementById('chosenanswer').innerHTML =content;
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
		alert(e);
                });
        </script> 
        <br>
        <hr>
        <div id ="chosenanswer" ></div>
        <hr>
        <div class="question"> Question ${question_nbr} : ${question} </div> 
        <br>
        <hr>
        <div class="answercontainer">
            <div class="answers answerA" id="answerAsquare">  
                <h2> A  </h2>
                <p id="answera"> ${answerA} </p>
            </div> 
            <div class="answers answerB" id="answerBsquare">
               <h2> B  </h2>
               <p id="answerb"> ${answerB} </p>
            </div></br>
            <div class="answers answerC" id="answerCsquare">
               <h2> C  </h2>
               <p id="answerc"> ${answerC} </p>
            </div> 
            <div class="answers answerD" id="answerDsquare">
               <h2> D  </h2>
               <p id="answerd"> ${answerD} </p>
            </div> 
        </div>
        
           
       
    </body>
</html>
