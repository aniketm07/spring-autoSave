document.addEventListener("DOMContentLoaded", () => {
    const SAVING_MESSAGE = "Saving...";
    const SAVED_MESSAGE = "All changes saved.";

    document.querySelectorAll(".auto-save-message").forEach(el => el.textContent = SAVED_MESSAGE);

    document.querySelectorAll("[data-autosave-url]").forEach(inputField => {
        inputField.addEventListener("change", async () => {
            const url = inputField.dataset.autosaveUrl;
            const autosaveMessageEl = inputField.closest(".container").querySelector(".auto-save-message");
            var data = {};

            // fetches all the value in text box
            inputField.closest(".container").querySelectorAll("[data-autosave-url]").forEach(input => {
                data[input.getAttribute("id")] = input.value;
            });

            // changes auto saving message
            autosaveMessageEl.classList.add("auto-save-message-saving");
            autosaveMessageEl.textContent = SAVING_MESSAGE;

            // post request to backend
            const response = await fetch(url, {
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                method: 'POST',
                body: JSON.stringify(data)
            });

            autosaveMessageEl.classList.remove("auto-save-message-saving");
            autosaveMessageEl.textContent = SAVED_MESSAGE;
        });
    })
})