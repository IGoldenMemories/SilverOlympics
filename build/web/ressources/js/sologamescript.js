

function displaytimer() {
    var seconds=60;
    var still_time = true;
    var timer_choice = '{timer}';
    if(timer_choice === "on"){
        document.getElementById("timer").innerHTML="1:00"; 
        timer = window.setInterval(function() {
            countdown();}, 1000);
        while(still_timer){
            document.getElementById('timerblock').style.display = "block";
            if(seconds < 60) {
                document.getElementById("timernbr").innerHTML = seconds;
            }
            if (seconds >0 ) {
                seconds--;
            } 
            else {
                clearInterval(still_time);
            }
        }
    }
    
}
        
    
    