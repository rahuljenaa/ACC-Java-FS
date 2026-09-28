package com.accenture.ltt.tx.listeners;

import java.util.Date;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;


public class MSDChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		System.out.println("Chunk ["+context+"] Started to execute on: "+new Date());
		
	}

	@Override
	public void afterChunk(ChunkContext context) {
		System.out.println("Chunk ["+context+"] Completed execution on: "+new Date());
		
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		System.out.println("Chunk ["+context+"] failed with execution on: "+new Date());
	}

}
