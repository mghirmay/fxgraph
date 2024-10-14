/**
 *
 */

module de.sinitpower.wsxGraph {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    requires java.prefs;
    requires java.desktop;
    requires org.abego.treelayout.core;
    requires java.logging;

    //java.lang.reflect.InaccessibleObjectException:
    // Unable to make field private int de.sinitpower.core.models.CueEntity.id
    // accessible: module de.sinitpower.wsxCoreOrmlite does not "opens de.sinitpower.core.models" to module ormlite.core

    exports de.sinitpower.fxgraph.graph;
    exports de.sinitpower.fxgraph.cells;
    exports de.sinitpower.fxgraph.edges;
    exports de.sinitpower.fxgraph.layout;

    opens de.sinitpower.fxgraph.exampleApps to javafx.graphics;

}