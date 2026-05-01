/**
 * 
 */

// Start from first slide (index 0)
let currentSlide = 0;

// Get all slides
const slides = document.querySelectorAll('.slide');

// Get all navigation dots
const dots = document.querySelectorAll('.nav-dot');


// Function to show a specific slide
function showSlide(index) {

    // Loop through all slides
    slides.forEach((slide, i) => {

        // Add 'active' class only to the current slide
        // Remove from others
        slide.classList.toggle('active', i === index);

        // Do the same for dots (current dot)
        dots[i].classList.toggle('active', i === index);
    });
}


// Function for next / previous button
function changeSlide(direction) {

    // Update slide index
    currentSlide = (currentSlide + direction + slides.length) % slides.length;

    // Show updated slide
    showSlide(currentSlide);
}


// Auto slide every 5 seconds
setInterval(() => {

    // Move to next slide automatically
    changeSlide(1);

}, 3000);


// Add click event to each dot
dots.forEach((dot, i) => {

    dot.addEventListener('click', () => {

        // Set current slide based on dot clicked
        currentSlide = i;

        // Show that slide
        showSlide(i);
    });

});