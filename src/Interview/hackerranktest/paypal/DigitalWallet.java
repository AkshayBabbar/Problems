package src.Interview.hackerranktest.paypal;

/**
* The DigitalWallet class should implement:
* 		The constructor DigitalWallet(String walletId, String userName).
* 		The constructor DigitalWallet(String walletId, String userName, String userAccessCode).
* 		The method String getWalletId() to return the wallet ID.
* 		The method String getUsername() to return the owner's user name.
* 		The method String getUserAccessToken() to return the access token.
* 		The method int getWalletBalance() to return the wallet balance.
* 		The method void setWalletBalance(int walletBalance) to update the wallet balance.
* */
public class DigitalWallet {
    private String walletId;
    private String userName;
    private String userAccessCode;

    public DigitalWallet(String walletId, String userName){
        this.userName = userName;
        this.walletId = walletId;
    }
    public DigitalWallet(String walletId, String userName,String userAccessCode){
        this.userName = userName;
        this.walletId = walletId;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }
}
