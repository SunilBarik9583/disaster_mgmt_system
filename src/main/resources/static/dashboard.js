document.addEventListener("DOMContentLoaded", function () {

    // ==============================
    // CHECK LOGIN TOKEN
    // ==============================

    const token = localStorage.getItem("token");

    if (!token) {
        window.location.href = "index.html";
        return;
    }

    // ==============================
    // LOAD LOGGED-IN USER PROFILE
    // ==============================

    fetch("/api/auth/me", {
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Unauthorized");
        }
        return response.json();
    })
    .then(user => {

        const emailElement = document.getElementById("userEmail");

        if (emailElement) {
            emailElement.innerText = user.email;
        }

    })
    .catch(error => {
        console.error("User fetch error:", error);
        localStorage.removeItem("token");
        window.location.href = "index.html";
    });


    // ==============================
    // DISASTER FORM SUBMIT
    // ==============================

    const form = document.getElementById("disasterForm");

    if (form) {
        form.addEventListener("submit", function (e) {
            e.preventDefault();

            fetch("/api/disaster/report", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token
                },
                body: JSON.stringify({
                    location: document.getElementById("location").value,
                    disasterType: document.title.includes("Flood") ? "Flood" :
                                  document.title.includes("Earthquake") ? "Earthquake" :
                                  document.title.includes("Fire") ? "Fire" :
                                  "General",
                    affectedPopulation: parseInt(document.getElementById("population").value),
                    severityLevel: parseInt(document.getElementById("severity").value),
                    vulnerablePopulation: parseInt(document.getElementById("vulnerable").value),
                    infrastructureDamage: parseInt(document.getElementById("damage").value)
                })
            })
            .then(res => res.json())
            .then(data => {

                const resultSection = document.getElementById("resultSection");
                const resultDiv = document.getElementById("result");

                if (resultSection && resultDiv) {

                    resultSection.style.display = "block";

                    resultDiv.innerHTML = `
                        <p><b>Priority Level:</b> ${data.priorityLevel}</p>
                        <p><b>Priority Score:</b> ${data.priorityScore}</p>
                        <p><b>Food Allocated:</b> ${data.foodAllocated}</p>
                        <p><b>Medical Kits:</b> ${data.medicalKits}</p>
                        <p><b>Rescue Teams:</b> ${data.rescueTeams}</p>
                        <p><b>Shelters:</b> ${data.shelters}</p>
                    `;
                }

            })
            .catch(error => {
                console.error("Disaster submit error:", error);
                alert("Error processing disaster data.");
            });
        });
    }

});


// ==============================
// SIDEBAR TOGGLE
// ==============================

function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    if (sidebar) {
        sidebar.classList.toggle("hidden");
    }
}


// ==============================
// PROFILE DROPDOWN TOGGLE
// ==============================

function toggleProfile() {
    const dropdown = document.getElementById("profileDropdown");
    if (dropdown) {
        dropdown.style.display =
            dropdown.style.display === "block" ? "none" : "block";
    }
}


// ==============================
// LOGOUT FUNCTION
// ==============================

function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("userEmail");
    window.location.href = "index.html";
}
