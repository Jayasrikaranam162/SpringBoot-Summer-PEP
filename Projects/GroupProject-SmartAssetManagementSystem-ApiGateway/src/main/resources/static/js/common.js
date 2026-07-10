document.addEventListener("DOMContentLoaded", function () {

    const currentPath = window.location.pathname;
    const sidebarLinks = document.querySelectorAll(".sidebar a");

    sidebarLinks.forEach(link => {
        const linkPath = link.getAttribute("href");

        if (!linkPath || linkPath === "#") {
            return;
        }

        if (
            currentPath === linkPath ||
            currentPath.startsWith(linkPath + "/")
        ) {
            link.classList.add("active");
        } else {
            link.classList.remove("active");
        }
    });
});