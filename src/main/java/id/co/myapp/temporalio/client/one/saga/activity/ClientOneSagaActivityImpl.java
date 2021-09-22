package id.co.myapp.temporalio.client.one.saga.activity;

public class ClientOneSagaActivityImpl implements ClientOneSagaActivity {

	@Override
	public String triggerClientOneActivity_seq1(String identifier) {
		String res = "Entering triggerClientOneActivity_seq1 for " + identifier;

		System.out.println(res);
		return res;
	}

}
