package nl.testchamber.mailordercoffeeshop.screenRobots;

import nl.testchamber.mailordercoffeeshop.R;

public class OrderScreenRobot extends BaseScreenRobot {

    private int nameEditText = R.id.name_text_box;
    private int emailEditText = R.id.email_text_box;
    private int submitOrderButton = R.id.mail_order_button;

    public OrderScreenRobot() {

    }

    public OrderScreenRobot setName(String name) {
        fillEditText(nameEditText, name);
        return this;
    }

    public OrderScreenRobot setEmail(String mail) {
        fillEditText(emailEditText, mail);
        return this;
    }

    public void submitOrder() {
        clickButton(submitOrderButton);
    }

}
