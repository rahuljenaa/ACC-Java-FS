package com.accenture.ltt.tx.listeners;

import java.util.Date;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

@Component
public class MSDChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		System.out.println("Chunk before["+context+"] Started to execute on: "+new Date());
		
	}

	@Override
	public void afterChunk(ChunkContext context) {
		System.out.println("Chunk after["+context+"] Completed execution on: "+new Date()+"\n");
		
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		System.out.println("Chunk Error["+context+"] failed with execution on: "+new Date());
	}

}
