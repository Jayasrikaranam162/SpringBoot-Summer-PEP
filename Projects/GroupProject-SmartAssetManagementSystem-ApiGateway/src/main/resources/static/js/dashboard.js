document.addEventListener("DOMContentLoaded", function () {

    const assetChartElement = document.getElementById("assetStatusChart");

    if (assetChartElement) {
        new Chart(assetChartElement, {
            type: "doughnut",
            data: {
                labels: ["Available", "Assigned", "Damaged", "Maintenance"],
                datasets: [{
                    data: [
                        assetChartElement.dataset.available,
                        assetChartElement.dataset.assigned,
                        assetChartElement.dataset.damaged,
                        assetChartElement.dataset.maintenance
                    ]
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: "bottom"
                    }
                }
            }
        });
    }
});