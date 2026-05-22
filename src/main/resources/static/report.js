let currentPage = 0;
const pageSize = 5;

document.addEventListener("DOMContentLoaded", function () {
    loadPage(currentPage);
});

function loadPage(page) {

    fetch(`/api/disaster/paginated?page=${page}&size=${pageSize}`)
        .then(response => response.json())
        .then(data => {

            const tableBody = document.getElementById("reportBody");
            tableBody.innerHTML = "";

            if (!data.content || data.content.length === 0) {
                tableBody.innerHTML =
                    "<tr><td colspan='14'>No Data Found</td></tr>";
                return;
            }

            data.content.forEach(report => {

                const row = document.createElement("tr");

                row.innerHTML = `
                    <td>${report.id}</td>
                    <td>${report.location}</td>
                    <td>${report.disasterType}</td>
                    <td>${report.affectedPopulation}</td>
                    <td>${report.severityLevel}</td>
                    <td>${report.vulnerablePopulation}</td>
                    <td>${report.infrastructureDamage}</td>
                    <td>${report.priorityLevel}</td>
                    <td>${report.priorityScore}</td>
                    <td>${report.foodAllocated}</td>
                    <td>${report.medicalKits}</td>
                    <td>${report.rescueTeams}</td>
                    <td>${report.shelters}</td>
                    <td>${report.createdAt}</td>
                `;

                tableBody.appendChild(row);
            });

            document.getElementById("pageInfo").innerText =
                `Page ${data.number + 1} of ${data.totalPages}`;

        });
}

function nextPage() {
    currentPage++;
    loadPage(currentPage);
}

function prevPage() {
    if (currentPage > 0) {
        currentPage--;
        loadPage(currentPage);
    }
}
