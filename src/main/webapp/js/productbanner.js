/**
 * Slider Script
 * Handles auto sliding, dot navigation, and active states
 */

// Start from first slide (index 0)
let currentSlide = 0;

// Select all slides 
const slides = document.querySelectorAll('.offer-slide');

// Select all navigation dots
const dots = document.querySelectorAll('.nav-dot');


// Function to show a specific slide
function showSlide(index) {

    // Remove 'active' class from all slides
    slides.forEach(slide => slide.classList.remove('active'));

    // Remove 'active' class from all dots
    dots.forEach(dot => dot.classList.remove('active'));

    // Add 'active' class to the current slide
    slides[index].classList.add('active');

    // Highlight the corresponding dot
    dots[index].classList.add('active');
}


// Function for automatic sliding
function autoSlide() {

    // Move to next slide (loop back to 0 at end)
    currentSlide = (currentSlide + 1) % slides.length;

    // Show updated slide
    showSlide(currentSlide);
}


// Start auto sliding every 5 seconds (5000ms)
let sliderInterval = setInterval(autoSlide, 3000);


// Add click event to each dot
dots.forEach((dot, index) => {

    dot.addEventListener('click', () => {

        // Set current slide to clicked dot index
        currentSlide = index;

        // Show selected slide
        showSlide(currentSlide);

        // Reset auto slider (restart timer)
        clearInterval(sliderInterval);

        // Start auto sliding again
        sliderInterval = setInterval(autoSlide, 5000);
    });
});


// Show the first slide when page loads
showSlide(currentSlide);