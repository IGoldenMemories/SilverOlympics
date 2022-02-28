<%-- 
    Document   : index
    Created on : 12-oct.-2021, 18:34:02
    Author     : Manon Michaux 
--%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SilverOlympics-Acceuil</title>
        <link rel="stylesheet" href="ressources/css/homepagestyle.css" >
        


    </head>
    <body>
        <div class="title">
            <h1>Bienvenue sur Silver Olympics </h1>
        </div>
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
                
                
                //New game asked
                if (content!==null && content === "A"){
                    document.getElementById("choice").style.display = "block";
                    document.getElementById('givenanswer').value ="Newgame";
                    //play audio with out html audio tag
                    var audioSuccess = new Audio('ressources/audio/ChoixAindex.mp3');
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
                    if(content!==null && content=== "C"){
                        document.getElementById("choice").style.display = "block";
                        document.getElementById('givenanswer').value ="end";
                        
                        
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
        ${AthemeMapping}
        <form name="end_of_screen" action="acceuil" method="post"  >
            <input type="hidden" id ="givenanswer" name="result"  />
            
        </form>
        <div class="imagescont">
            <div class="imgcontainer imgA" >
                <img src="ressources/img/signA.png" alt="signA">   
            </div>
            <div class="textlegendA">  Pour lancer une partie montrer le qr Code A! </div>
        
            <div class="imgcontainer imgB"> 
                <img src="ressources/img/signB.png" alt="signB">
            </div>
        
            <div class="textlegendB">  Pour accéder à la page d'aide, montrer le qr Code B! </div>
        </div>
        <!--<div class="solobutton"><button> 
                <a href="${pageContext.request.contextPath}/jeusolooptions"> Entraînement </a></button> 
        </div>
        -->
        <br>
        <div class="center imagebackground" id="backimage">
           
        </div>
        <script type="text/javascript" src="ressources/js/homepagehandler.js"></script>  
        

        

    </body>
</html>
