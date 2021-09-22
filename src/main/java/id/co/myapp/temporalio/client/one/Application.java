package id.co.myapp.temporalio.client.one;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import id.co.myapp.temporalio.client.one.saga.workflow.ClientOneSagaWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WorkflowServiceStubs service = WorkflowServiceStubs
				.newInstance(WorkflowServiceStubsOptions.newBuilder().setTarget(Shared.TEMPORAL_SERVER).build());
		WorkflowClient client = WorkflowClient.newInstance(service);
		WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(Shared.CLIENT_ONE_TASK_QUEUE).build();

		ClientOneSagaWorkflow workflow = client.newWorkflowStub(ClientOneSagaWorkflow.class, options);
		String res = workflow.triggerClientOneWorkflow(RandomStringUtils.randomNumeric(6));
		System.out.println(res);
	}

}
