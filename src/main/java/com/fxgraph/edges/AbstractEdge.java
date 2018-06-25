package com.fxgraph.edges;

import com.fxgraph.graph.ICell;
import com.fxgraph.graph.IEdge;

public abstract class AbstractEdge implements IEdge {

	private final ICell source;
	private final ICell target;

	public AbstractEdge(ICell source, ICell target) {
		this.source = source;
		this.target = target;

		source.addCellChild(target);
		target.addCellParent(source);
	}

	@Override
	public ICell getSource() {
		return source;
	}

	@Override
	public ICell getTarget() {
		return target;
	}

}
