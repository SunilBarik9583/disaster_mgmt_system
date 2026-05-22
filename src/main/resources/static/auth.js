document.addEventListener("DOMContentLoaded", function () {

    const signupForm = document.getElementById("signupForm");
    const loginForm = document.getElementById("loginForm");

    // ========================
    // SIGNUP
    // ========================
    if (signupForm) {
        signupForm.addEventListener("submit", function (e) {
            e.preventDefault();

            const email = document.getElementById("signupEmail").value;
            const password = document.getElementById("signupPassword").value;

            fetch("/api/auth/signup", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    email: email,
                    password: password
                })
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Signup failed");
                }
                return response.text();
            })
            .then(data => {
                alert("Registration Successful!");
                window.location.href = "index.html";
            })
            .catch(error => {
                alert("Error during signup.");
                console.error(error);
            });
        });
    }

    // ========================
    // LOGIN
    // ========================
    if (loginForm) {
        loginForm.addEventListener("submit", function (e) {
            e.preventDefault();

            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            fetch("/api/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    email: email,
                    password: password
                })
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Invalid credentials");
                }
                return response.json();
            })
            .then(data => {

                // Save JWT token
                localStorage.setItem("token", data.token);

                // Optional: Save email
                localStorage.setItem("userEmail", email);

                // Redirect
                window.location.href = "dashboard.html";
            })
            .catch(error => {
                alert("Login failed. Check credentials.");
                console.error(error);
            });
        });
    }

});
