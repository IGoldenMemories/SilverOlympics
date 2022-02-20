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
    </head>
    <body>
        
        <video id="preview" class="webcam_output"></video>
        <script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
        <script type="text/javascript">
            var scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5, mirror: false });
            scanner.addListener('scan',function(content){
		alert(content);
                
                
                if(content!==null && content==="A"){
                    document.getElementById("givenanswer").value = "A";
                }
                else{
                    if(content!==null && content==="B"){
                        document.getElementById("givenanswer").value = "B";
                    }
                    else{
                        if(content!==null && content==="C"){
                            document.getElementById("givenanswer").value = "C";
                        }
                        else{
                            alert("Essayez de montrer le qr code correspondant à A B ou C plutôt");
                        }
                    }
                }
                var delayInMilliseconds = 5000; //10 seconds
                setTimeout(function() {
                    document.next_screen_choice.submit();
                }, delayInMilliseconds);
                
                
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
        <h1>Félicitation vôtre score est de :</h1>
        <div class="scoredisplay"> ${score} </div>
        <form name="next_screen_choice" action="ecranfinpartie" method="post" >
            Voulez-vous recommencer une partie ?
            <hr>
            Avec les mêmes options? 
            
            <hr>
            Ou 
            Avec des options différentes ?
            
            <hr>
            Souhaitez vous plutôt revenir au menu principal
            
            <input type="hidden" id ="givenanswer" name="result" />
            
        </form>
        <div id="chosenotp"> </div>
        
        
        
        
    </body>
</html>
