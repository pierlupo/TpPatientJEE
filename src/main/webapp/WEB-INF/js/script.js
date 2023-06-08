// $(document).ready(function(){
//     $('#menuToggle').click(function(){
//         $('#mainNav').stop(true, true).slideToggle()
//     })
// })

// function agrandir() {
//     let myImg = document.getElementById("myImg");
//     let width = myImg.clientWidth;
//     if (width == 600) {
//     console.log("Vous avez atteint le niveau de zoom maximal.");
//     } else {
//         myImg.style.width = (width + 20) + "px";
//     }
// }
// function diminuer() {
//     let myImg = document.getElementById("myImg");
//     let width = myImg.clientWidth;
//     if (width == 40) {
//     console.log("Vous avez atteint le niveau de zoom minimal.");
//     } else {
//         myImg.style.width = (width - 20) + "px";
//     }
// }

// let links = document.getElementsByTagName('a'),
//     linksLen = links.length;
// for (let i = 0 ; i < linksLen ; i++) {
//     links[i].onclick = function() { // Vous pouvez très bien utiliser le DOM-2
//         displayImg(this); // On appelle notre fonction pour afficher les images et on lui passe le lien concerné
//         return false; // Et on bloque la redirection
//     };
// }
// function displayImg(link) {
//     let img = new Image();
//     img.onload = function() {
//       // Affichage de l'image
//     };
//        img.src = link.href;
// }
// function displayImg(link) {
//     let img = new Image(),
//         overlay = document.getElementById('overlay');
//     img.onload = function() {
//         overlay.innerHTML = '';
//         overlay.appendChild(img);
//     };
//     img.src = link.href;
//     overlay.style.display = 'block';
//     overlay.innerHTML = '<span>Chargement en cours...</span>';
// }
// document.getElementById('overlay').onclick = function() {
//     this.style.display = 'none';
// };


// Open the Modal
function openModal() {
    document.getElementById("myModal").style.display = "block";
}

// Close the Modal
function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("demo");
    let captionText = document.getElementById("caption");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    captionText.innerHTML = dots[slideIndex-1].alt;

}