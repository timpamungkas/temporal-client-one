package id.co.myapp.temporalio.client.one.helloworld.worker;

import id.co.myapp.temporalio.client.one.Shared;
import id.co.myapp.temporalio.client.one.helloworld.activity.FormatActivityImpl;
import id.co.myapp.temporalio.client.one.helloworld.activity.ThankYouActivityImpl;
import id.co.myapp.temporalio.client.one.helloworld.workflow.HelloWorldWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloWorldWorker {

	public static void main(String[] args) {
		WorkflowServiceStubs service = WorkflowServiceStubs
				.newInstance(WorkflowServiceStubsOptions.newBuilder().setTarget(Shared.TEMPORAL_SERVER).build());
		WorkflowClient client = WorkflowClient.newInstance(service);
		// Create a Worker factory that can be used to create Workers that poll specific
		// Task Queues.
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker(Shared.HELLO_WORLD_TASK_QUEUE);
		// This Worker hosts both Workflow and Activity implementations.
		// Workflows are stateful, so you need to supply a type to create instances.
		worker.registerWorkflowImplementationTypes(HelloWorldWorkflowImpl.class);
		// Activities are stateless and thread safe, so a shared instance is used.
		worker.registerActivitiesImplementations(new FormatActivityImpl(), new ThankYouActivityImpl());
		// Start polling the Task Queue.
		factory.start();
	}

}