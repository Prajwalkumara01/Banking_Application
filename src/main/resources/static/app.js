const BASE_URL = "http://localhost:8080/api"; // Your backend API URL


// Create account function
async function createAccount(userId,useraccountnumber, balance) {
  try {
    const response = await fetch(`${BASE_URL}/accounts`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId,useraccountnumber, balance })
    });

    if (response.ok) {
      const data = await response.json();
      alert("Account Created Successfully!");
      window.location.href = "dashboard.html";  // Redirect to dashboard after account creation
    } else {
      console.error("Account creation failed");
      alert("Failed to create account.");
    }
  } catch (error) {
    console.error("Error creating account:", error);
  }
}

// Create account form submission
 const createAccountForm = document.getElementById("createAccountForm");
 if (createAccountForm) {
   createAccountForm.addEventListener("submit", function(event) {
     event.preventDefault();
	 const userId=document.getElementById("userId").value;
     const useraccountnumber = document.getElementById("useraccountnumber").value;
     const balance = document.getElementById("balance").value;
     createAccount(userId,useraccountnumber,balance);
   });
 }

// Transfer Money function
// Transfer Money function
async function transferMoney( fromAccountnumber, toAccountnumber, amount) {
  try {
    const response = await fetch(`${BASE_URL}/transfer`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        fromAccountnumber: fromAccountnumber,
        toAccountnumber: toAccountnumber,
        amount: amount
      })
    });

    if (response.ok) {
      alert("Money Transferred Successfully!");
      window.location.href = "dashboard.html";  // Redirect to dashboard after successful transfer
    } else {
      console.error("Transfer failed");
      alert("Failed to transfer money.");
    }
  } catch (error) {
    console.error("Error transferring money:", error);
  }
}



// Transfer money form submission
const transferForm = document.getElementById("transferForm");
if (transferForm) {
    transferForm.addEventListener("submit", function(event) {
        event.preventDefault();
        const fromAccountnumber = document.getElementById("fromAccountnumber").value;
        const toAccountnumber = document.getElementById("toAccountnumber").value;
        const amount = document.getElementById("amount").value;
        
        // Now calling with id properly
        transferMoney(fromAccountnumber, toAccountnumber, amount);
    });
}


// View Transaction History function
async function getTransactionHistory() {
  const accountId = document.getElementById("accountnumber").value;
  try {
    const response = await fetch(`${BASE_URL}/transactions/${accountId}`);

    if (response.ok) {
      const transactions = await response.json();
      document.getElementById('transactionsResult').innerHTML = JSON.stringify(transactions, null, 2);
    } else {
      console.error("Failed to fetch transaction history");
      alert("Failed to fetch transactions.");
    }
  } catch (error) {
    console.error("Error getting transaction history:", error);
  }
}

// View transaction history
const viewTransactionsBtn = document.getElementById("viewTransactions");
  if (viewTransactionsBtn) {
    viewTransactionsBtn.addEventListener("click", getTransactionHistory);
  }

// View Balance function
async function getBalance() {
  const useraccountnumber = document.getElementById("useraccountnumber").value; 
  try {
    const response = await fetch(`${BASE_URL}/balance/${useraccountnumber}`);
    if (response.ok) {
      const balance = await response.json();
      document.getElementById('balanceResult').innerText = "Balance: " + balance;
    } else {
      console.error("Failed to fetch balance");
      alert("Failed to get balance.");
    }
  } catch (error) {
    console.error("Error viewing balance:", error);
  }
}


// View balance
 const viewBalanceBtn = document.getElementById("viewBalance");
 if (viewBalanceBtn) {
   viewBalanceBtn.addEventListener("click", getBalance);
 }

// Form event listeners
document.addEventListener("DOMContentLoaded", function() {
 


});
