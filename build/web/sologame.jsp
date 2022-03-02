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
        <div class="displayansw" id = "resultquestion"> <div  id="chosenanswer"></div></div>
        <div class="scoreblock"> Score:  ${score} </div>
        
        <center>
            <div class="webcamcontainer">
                <video id="preview" class="webcam_output"></video>
            </div>
        </center>
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		//alert(content);
                
                document.getElementById('chosenanswer').innerHTML =content;
                
                
                var right_answer = '${correctAnswer}';
                //Success scenario 
                if (content!==null && content === right_answer){
                    document.getElementById("resultquestion").style.display = "block";
                    
                    //chooses randomly one of the success phrases
                    var citations = [],indexcitation =0;
                    citations[0] = "  Bien joué ! ";
                    citations[1] = "  Félicitations ! ";
                    citations[2] = "  Chapeau ! ";
                    indexcitation = Math.floor(Math.random() * citations.length);
                    document.getElementById('chosenanswer').innerHTML = citations[indexcitation];
                    
                    //chooses randomly one of the success audio
                    var audio_src = [],index = 0;
                    audio_src[0] = "ressources/audio/success_one.mp3";
                    audio_src[1] = "ressources/audio/success_two.mp3";
                    audio_src[2] = "ressources/audio/success_three.mp3";
                    index = Math.floor(Math.random() * audio_src.length);

                    //play audio with out html audio tag
                    var audioSuccess = new Audio(audio_src[index]);
                    audioSuccess.volume = 0.8;
                    audioSuccess.play();
                    if(content==="A"){
                        //Changing the color of the "answer"
                        var square_a = document.getElementById("answerAsquare");
                        square_a.style.backgroundColor = "#99cc00";
                        
                    }
                    if(content==="B"){
                        //Changing the color of the "answer"
                        var square_b = document.getElementById("answerBsquare");
                        square_b.style.backgroundColor = "#99cc00";
                        
                    }
                    if(content==="C"){
                        //Changing the color of the "answer"
                        var square_c = document.getElementById("answerCsquare");
                        square_c.style.backgroundColor = "#99cc00";
                        
                    }
                    if(content==="D"){
                        //Changing the color of the "answer"
                        var square_d = document.getElementById("answerDsquare");
                        square_d.style.backgroundColor = "#99cc00";
                        
                    }
                   
                    
                    document.getElementById("givenanswer").value = "success";
                    
                    var delayInMilliseconds = 5000; //10 seconds

                        setTimeout(function() {
                            document.end_of_screen.submit();
                            
                            }, delayInMilliseconds);
                    
                }
                //failure scenario (given answer(in content variable) != correct answer)
                else{
                    if(content!==null && content!== right_answer){
                        document.getElementById("resultquestion").style.display = "block";
                        //chooses randomly one of the success phrases
                        var citations = [],indexcitation =0;
                        citations[0] = "  La prochaine sera la bonne ! ";
                        citations[1] = "  Bien essayé ! ";
                        citations[2] = "  Dommage !  ";
                        indexcitation = Math.floor(Math.random() * citations.length);
                        document.getElementById('chosenanswer').innerHTML = citations[indexcitation];
                        
                        
                        //chooses randomly one of the success audio
                        var audio_src = [],index = 0;
                        audio_src[0] = "ressources/audio/fail_one.mp3";
                        audio_src[1] = "ressources/audio/fail_two.mp3";
                        audio_src[2] = "ressources/audio/fail_three.mp3";
                        index = Math.floor(Math.random() * audio_src.length);

                        //play audio with out html audio tag
                        var audioSuccess = new Audio(audio_src[index]);
                        audioSuccess.volume = 0.8;
                        audioSuccess.play();
                        //Given answer is A
                        if(content==="A"){
                            //Changing color of wrong given answer to red 
                            var square_a = document.getElementById("answerAsquare");
                            square_a.style.backgroundColor = '#800000';
                            //Changing color of right answer to green
                            if(right_answer==="B"){
                                var square_b = document.getElementById("answerBsquare");
                                square_b.style.backgroundColor = '#99cc00';
                                
                            }
                            if(right_answer==="C"){
                                var square_c = document.getElementById("answerCsquare");
                                square_c.style.backgroundColor = '#99cc00';
                                
                            }
                            
                            if(right_answer==="D"){
                                var square_d = document.getElementById("answerDsquare");
                                square_d.style.backgroundColor = '#99cc00';
                                
                            }
                        }
                        //Given answer is B
                        if(content==="B"){
                            //Changing color of wrong given answer to red 
                            var square_b = document.getElementById("answerBsquare");
                            square_b.style.backgroundColor = '#800000';
                            //Changing color of right answer to green
                            if(right_answer==="A"){
                                var square_a = document.getElementById("answerAsquare");
                                square_a.style.backgroundColor = '#99cc00';
                                
                            }
                            if(right_answer==="C"){
                                var square_c = document.getElementById("answerCsquare");
                                square_c.style.backgroundColor = '#99cc00';
                                
                            }
                            
                            if(right_answer==="D"){
                                var square_d = document.getElementById("answerDsquare");
                                square_d.style.backgroundColor = '#99cc00';
                                
                            }
                            
                        }
                        //Given answer is C
                        if(content==="C"){
                            //Changing color of wrong given answer to red 
                            var square_c = document.getElementById("answerCsquare");
                            square_c.style.backgroundColor = '#800000';
                            //Changing color of right answer to green
                            if(right_answer==="A"){
                                var square_a = document.getElementById("answerAsquare");
                                square_a.style.backgroundColor = '#99cc00';
                                
                            }
                            if(right_answer==="B"){
                                var square_b = document.getElementById("answerBsquare");
                                square_b.style.backgroundColor = '#99cc00';
                                
                            }
                            
                            if(right_answer==="D"){
                                var square_d = document.getElementById("answerDsquare");
                                square_d.style.backgroundColor = '#99cc00';
                                
                            }
                            
                        }
                        //Given answer is D
                        if(content==="D"){
                            //Changing color of wrong given answer to red 
                            var square_c = document.getElementById("answerCsquare");
                            square_c.style.backgroundColor = '#800000';
                            //Changing color of right answer to green
                            if(right_answer==="A"){
                                var square_a = document.getElementById("answerAsquare");
                                square_a.style.backgroundColor = '#99cc00';
                                
                            }
                            if(right_answer==="C"){
                                var square_c = document.getElementById("answerCsquare");
                                square_c.style.backgroundColor = '#99cc00';
                                
                            }
                            
                            if(right_answer==="B"){
                                var square_b = document.getElementById("answerBsquare");
                                square_b.style.backgroundColor = '#99cc00';
                                
                            }
                        }
                        document.getElementById("givenanswer").value = "fail";
                        var delayInMilliseconds = 5000; //5 seconds

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
		alert(e);
                });
        </script> 
        
        <br>
        
        <form name="end_of_screen" action="jeusolo" method="post"  >
            <input type="hidden" id ="givenanswer" name="result"  />
            
        </form>
        
        <div class="question"> Question  ${question_number} : ${question} <br /></div> 
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
