
// Debounce do lodash
// Fazer com que a função não seja ativada mihares de vezes
const debounce = function(func, wait, immediate){
    let timeout
    return function(...args) {
        const context = this
        const later = function() {
            timeout = null
            if(!immediate) func.apply(context, args)
        }
        const callNow = immediate && !timeout
        clearTimeout(timeout)
        timeout = setTimeout(later, wait)
        if(callNow) func.apply(context, args)
    }
}

const target = document.querySelectorAll('[data-anime]')
const animationClass = 'animate'

function animeScroll(){
    const windowTop = window.pageYOffset + ((window.innerHeight * 3) / 4)
    target.forEach(function(element){
        if((windowTop) > element.offsetTop) {
            element.classList.add(animationClass);
        } 
        // else {
        //     element.classList.remove(animationClass)
        // }
    })
}

animeScroll();

// Verificar se possui target(animação) ou não no site
if(target.length) {
    window.addEventListener('scroll', debounce (function() {
        animeScroll();
        console.log('sadasf')
    }, 200))
}

/* *********************************  */

/*

const target2 = document.querySelectorAll('[data-anime-card]')
const animationClass2 = 'animate'

function animeScroll2(){
    const windowTop = window.pageYOffset + ((window.innerHeight * 3) / 4)
    target2.forEach(function(element){
        if((windowTop) > element.offsetTop) {
            element.classList.add(animationClass2);
        } else {
            element.classList.remove(animationClass2)
        }
    })
}

animeScroll();

// Verificar se possui target(animação) ou não no site
if(target.length) {
    window.addEventListener('scroll', debounce (function() {
        animeScroll2();
        console.log('sadasf')
    }, 200))
}

*/
