function randombuttonaction() {
                 document.getElementById('explanationrandom').style.display = "block";
            }
var count = 1;
            function setColor(btn) {
                var property = document.getElementById(btn);
                if (count === 0) {
                    property.style.backgroundColor = "#FFFFFF";
                    count = 1;        
                }
                else {
                    property.style.backgroundColor = "#7FFF00";
                    count = 0;
                }
            }