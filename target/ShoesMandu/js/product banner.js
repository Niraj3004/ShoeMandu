/**
 * 
 */

let currentSlide = 0;
   const slides = document.querySelectorAll('.offer-slide');
   const dots = document.querySelectorAll('.nav-dot');

   function showSlide(index) {
       slides.forEach(slide => slide.classList.remove('active'));
       dots.forEach(dot => dot.classList.remove('active'));

       slides[index].classList.add('active');
       dots[index].classList.add('active');
   }

   function autoSlide() {
       currentSlide = (currentSlide + 1) % slides.length;
       showSlide(currentSlide);
   }

   let sliderInterval = setInterval(autoSlide, 5000);

   dots.forEach((dot, index) => {
       dot.addEventListener('click', () => {
           currentSlide = index;
           showSlide(currentSlide);

           clearInterval(sliderInterval);
           sliderInterval = setInterval(autoSlide, 5000);
       });
   });

   showSlide(currentSlide);
