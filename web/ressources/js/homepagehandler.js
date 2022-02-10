

var images_src = [],index = 0;
images_src[0] = "ressources/img/bugs.jpg";
images_src[1] = "ressources/img/pyramids.jpg";
images_src[2] = "ressources/img/library.jpg";
images_src[3] = "ressources/img/sunflower.jpg";
images_src[4] = "ressources/img/moulins.jpg";
index = Math.floor(Math.random() * images_src.length);

var displayed_img = document.createElement("img");
displayed_img.src =images_src[index];
displayed_img.setAttribute("height", "500");
displayed_img.setAttribute("width", "1000");

document.getElementById("backimage").appendChild(displayed_img);