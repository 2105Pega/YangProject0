package model;

public class Account {
		private int accountId;
		private double balance;
		private String status;

		public Account() {
			super();
		}

		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			if(accountId<1)
			{
				System.out.println("Please enter a valid account number!");
				System.exit(0);
			}
			this.accountId = accountId;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			if(balance<0)
			{
				System.out.println("Please enter a valid balance!");
				System.exit(0);
			}
			else
			this.balance = balance;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			if(status.toLowerCase().equals("applied"))
			  this.status = status;
			else if(status.toLowerCase().equals("active"))
				this.status=status;
			else
			{
				System.out.println("Please enter a valid status!");
				System.exit(0);
			}
		}		

		@Override
		public String toString() {
			return "Account info: [accountId=" + accountId + ", balance=" + balance + ", status=" + status + "]";
		}
}
