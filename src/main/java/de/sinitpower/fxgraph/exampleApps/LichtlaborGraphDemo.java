package de.sinitpower.fxgraph.exampleApps;

import de.sinitpower.fxgraph.cells.RectangleCell;
import de.sinitpower.fxgraph.cells.TriangleCell;
import de.sinitpower.fxgraph.edges.CorneredEdge;
import de.sinitpower.fxgraph.edges.CorneredLoopEdge;
import de.sinitpower.fxgraph.edges.CorneredLoopEdge.Position;
import de.sinitpower.fxgraph.edges.DoubleCorneredEdge;
import de.sinitpower.fxgraph.edges.Edge;
import de.sinitpower.fxgraph.graph.Graph;
import de.sinitpower.fxgraph.graph.ICell;
import de.sinitpower.fxgraph.graph.Model;
import de.sinitpower.fxgraph.layout.AbegoTreeLayout;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.abego.treelayout.Configuration.Location;

public class LichtlaborGraphDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Graph graph = new Graph();

		// Add content to graph
		populateGraph(graph);

		// Layout nodes
		AbegoTreeLayout layout = new AbegoTreeLayout(200, 200, Location.Top);
		graph.layout(layout);

		// Configure interaction buttons and behavior
		graph.getViewportGestures().setPanButton(MouseButton.SECONDARY);
		graph.getNodeGestures().setDragButton(MouseButton.PRIMARY);

		// Display the graph
		stage.setScene(new Scene(new BorderPane(graph.getCanvas())));
		stage.show();
	}

	private void populateGraph(Graph graph) {
		final Model model = graph.getModel();
		graph.beginUpdate();
		final ICell cellA = new RectangleCell();
		final ICell cellB = new TriangleCell();
		final ICell cellC = new TriangleCell();
		final ICell cellD = new TriangleCell();
		final ICell cellE = new TriangleCell();
		final ICell cellF = new TriangleCell();
		final ICell cellG = new TriangleCell();

		model.addCell(cellA);
		model.addCell(cellB);
		model.addCell(cellC);
		model.addCell(cellD);
		model.addCell(cellE);
		model.addCell(cellF);
		model.addCell(cellG);

		final Edge edgeAB = new Edge(cellA, cellB, true);
		edgeAB.textProperty().set("Directed Edge");
		model.addEdge(edgeAB);

		final CorneredEdge edgeAC = new CorneredEdge(cellA, cellC, true, Orientation.HORIZONTAL);
		edgeAC.textProperty().set("Directed CorneredEdge");
		model.addEdge(edgeAC);

		final DoubleCorneredEdge edgeBE = new DoubleCorneredEdge(cellA, cellE, true, Orientation.HORIZONTAL);
		edgeBE.textProperty().set("Directed DoubleCorneredEdge");
		model.addEdge(edgeBE);

		final Edge edgeCF = new Edge(cellA, cellF, true);
		edgeCF.textProperty().set("Directed Edge");
		model.addEdge(edgeCF);

		final CorneredLoopEdge loopFTop = new CorneredLoopEdge(cellF, Position.TOP);
		loopFTop.textProperty().set("Loop top");
		model.addEdge(loopFTop);

		model.addEdge(cellA, cellG);

		model.addEdge(cellA, cellD);

		graph.endUpdate();
	}
}
