
function checkAuth() {
    const userId = localStorage.getItem('userId');
    if (!userId && !window.location.href.includes('index.html') && 
        !window.location.href.includes('login.html') && 
        !window.location.href.includes('signup.html')) {
        window.location.href = 'login.html';
    }
}

function logout() {
    localStorage.removeItem('userId');
    localStorage.removeItem('username');
    window.location.href = 'index.html';
}

function showMessage(message, type) {
    const messageDiv = document.getElementById('message');
    if (messageDiv) {
        messageDiv.textContent = typeof message === 'string' ? message : JSON.stringify(message);
        messageDiv.className = type;
        messageDiv.style.display = 'block';
    }
}
