/*
 * Copyright (c) 2009-10 Daniel Nyga
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Technische Universiteit Eindhoven nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
*/
package instruction.postprocessor;

import instruction.importer.AddCycMappingListener;
import instruction.semanticObjects.Instruction;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Daniel Nyga
 * 
 */
public class InstructionPostProcessor {
	
	private List<PostProcessor> registry = new ArrayList<PostProcessor>();
	private MeaningsPostProcessor meaningsPostProc;
	
	
	public InstructionPostProcessor() {
		
	//	registry.add( new InstructionFilterPostProcessor() );
		registry.add( new PrepareActionsPostProcessor() );
		registry.add( new PreparePrepositionalPhrasesPostProcessor() );
		registry.add( new BuildObjectNamesPostProcessor() );
		registry.add( new PronounResolverPostProcessor() );	
		meaningsPostProc = new MeaningsPostProcessor();
		registry.add( meaningsPostProc );
		registry.add( new ObjectAmountPostProcessor() );
		registry.add( new TimeConstraintPostProcessor() );
		registry.add( new OptionalPostprocessor() );
	}

	/**
	 * Runs the PostProcessor on the given List of Instructions
	 * 
	 * @param instructions
	 * @throws Exception
	 */
	public void run( List<Instruction> instructions ) throws Exception {
		
		// Run all registered PostProcessors
		for (int i = 0; i < registry.size(); i++) 
			registry.get( i ).run( instructions );
		
	}


	public void printArray( ArrayList a ) {

		for ( int i = 0; i < a.size(); i++ )
			System.out.print( a.get( i ).toString() + " | " );
		System.out.println( "" );
	}
	
	public void setAddMappingListener(AddCycMappingListener listener) {
		meaningsPostProc.setAddMappingListener(listener);
	}
}
