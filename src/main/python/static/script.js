const functionBlocks = document.querySelectorAll(".div-func");
const body = document.body
functionBlocks.forEach((functionBlock) => {
    const button = functionBlock.querySelector(".func_button");
    const form = functionBlock.querySelector(".func_form");
    
    button.addEventListener("click", () => {
        const isActive = form.classList.toggle("active");
        body.disabled = isActive
        functionBlocks.forEach((otherBlock) => {
            const otherButton = otherBlock.querySelector(".func_button");

            if (otherButton !== button) {
                otherButton.disabled = isActive;
            }
        });
    });
});

const functionsSection = document.querySelector(".all-funcs");

// const observer = new IntersectionObserver(
//     (entries, observer) => {
//         entries.forEach((entry) => {
//             if (entry.isIntersecting) {
//                 entry.target.classList.add("is-visible");
//                 observer.unobserve(entry.target);
//             }
//         });
//     },
//     {
//         threshold: 0.15
//     }
// );

// observer.observe(functionsSection);

