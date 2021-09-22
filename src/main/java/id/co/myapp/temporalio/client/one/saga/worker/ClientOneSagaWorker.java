package id.co.myapp.temporalio.client.one.saga.worker;

import id.co.myapp.temporalio.client.one.Shared;
import id.co.myapp.temporalio.client.one.saga.activity.ClientOneSagaActivityImpl;
import id.co.myapp.temporalio.client.one.saga.workflow.ClientOneSagaWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class ClientOneSagaWorker {

	public static void main(String[] args) {
		WorkflowServiceStubs service = WorkflowServiceStubs
				.newInstance(WorkflowServiceStubsOptions.newBuilder().setTarget(Shared.TEMPORAL_SERVER).build());
		WorkflowClient client = WorkflowClient.newInstance(service);
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker(Shared.CLIENT_ONE_TASK_QUEUE);
		worker.registerWorkflowImplementationTypes(ClientOneSagaWorkflowImpl.class);
		worker.registerActivitiesImplementations(new ClientOneSagaActivityImpl());
		factory.start();
	}

}