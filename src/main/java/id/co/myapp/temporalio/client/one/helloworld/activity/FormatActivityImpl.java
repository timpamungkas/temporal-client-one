package id.co.myapp.temporalio.client.one.helloworld.activity;

public class FormatActivityImpl implements FormatActivity {

	@Override
	public String composeGreeting(String name) {
		return "Hello " + name + "!";
	}

}
