const functionBlocks = document.querySelectorAll(".div-func");

functionBlocks.forEach((functionBlock) => {
    const button = functionBlock.querySelector(".func_button");
    const form = functionBlock.querySelector(".func_form");

    form.style.display = "none";

    button.addEventListener("click", () => {
        form.style.display = form.style.display === "none" ? "" : "none";
    });
    
});

const functionsSection = document.querySelector(".all-funcs");

const observer = new IntersectionObserver(
    (entries, observer) => {
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                entry.target.classList.add("is-visible");
                observer.unobserve(entry.target);
            }
        });
    },
    {
        threshold: 0.15
    }
);

observer.observe(functionsSection);

