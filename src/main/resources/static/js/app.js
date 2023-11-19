// Initially, only display the home screen
window.onload = function() {
    document.getElementById("homeScreen").style.display = "block";
    document.getElementById("mainContent").style.display = "none";
    document.getElementById("inputSection").style.display = "block";
    document.getElementById("outputSection").style.display = "none";
}

// Event Listener for Get Started button
document.querySelector("#homeScreen button").addEventListener("click", function() {
    // Trigger the modal to be shown
    $("#loginModal").modal("show");
});

// When modal is closed
$('#loginModal').on('hidden.bs.modal', function (e) {
    document.getElementById("homeScreen").style.display = "none";
    document.getElementById("mainContent").style.display = "block";
})
//TODO : check login functionality thoroughly. sometimes not redirecting correct?
// Event listener for the login button inside the modal
document.getElementById("loginButton").addEventListener("click", function(event) {
    event.preventDefault(); // prevent the form from refreshing the page
    $("#loginModal").modal("hide"); // close the modal
});

document.getElementById("adviceForm").addEventListener("submit", function(event) {
    event.preventDefault(); // prevent the form from refreshing the page

    // Hide the home screen and show the main content
    document.getElementById("homeScreen").style.display = "none";
    document.getElementById("mainContent").style.display = "block";
    submitForm();
});

    function submitForm() {
        var symptom = document.getElementById("symptom").value;

        fetch("/advice?symptom=" + encodeURIComponent(symptom))
            .then(response => response.text())
            .then(advice => {
                document.getElementById("inputSection").style.display = "none";
                document.getElementById("outputSection").style.display = "block";
                typeAdvice(advice);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
// TODO : Align the advice generated -check the tags  used- <n> and <p>
   function typeAdvice(advice) {
       let adviceOutput = document.getElementById("adviceOutput");
       adviceOutput.innerHTML = ''; // Resetting the advice output

       // Replacing the <p> and <n> tags with appropriate new lines
       advice = advice.replace(/<p>/g, "\n\n").replace(/<n>/g, "\n");

       let i = 0;
       let typingEffect = setInterval(() => {
           if (advice.charAt(i) === "\n") {
               adviceOutput.innerHTML += "<br>"; // Adding a line break in the HTML
           } else {
               adviceOutput.innerText += advice.charAt(i);
           }
           i++;
           if (i >= advice.length) {
               clearInterval(typingEffect);
           }
       }, 50); // Adjust the number to make the typing effect faster or slower
   }


    function resetForm() {
        document.getElementById("inputSection").style.display = "block";
        document.getElementById("outputSection").style.display = "none";
        document.getElementById("symptom").value = "";
        document.getElementById("adviceOutput").innerText = "";
    }
