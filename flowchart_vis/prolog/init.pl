/** 
  Copyright (C) 2013 Moritz Tenorth
  All rights reserved.

  Redistribution and use in source and binary forms, with or without
  modification, are permitted provided that the following conditions are met:
      * Redistributions of source code must retain the above copyright
        notice, this list of conditions and the following disclaimer.
      * Redistributions in binary form must reproduce the above copyright
        notice, this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
      * Neither the name of the <organization> nor the
        names of its contributors may be used to endorse or promote products
        derived from this software without specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
  DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
  DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

  @author Moritz Tenorth
  @license BSD
*/


:- register_ros_package(mod_vis).
:- register_ros_package(ias_semantic_map).
:- register_ros_package(knowrob_mesh_reasoning).
:- register_ros_package(knowrob_cad_models).
:- register_ros_package(knowrob_motion_constraints).
:- register_ros_package(comp_ehow).
:- register_ros_package(rosprac).

% test objects for CAD segmentation
:- owl_parser:owl_parse('package://flowchart_vis/owl/test-objects.owl').

% pancake instructions:
%:- owl_parser:owl_parse('@COMP_EHOW_PACKAGE_PATH@/make_pancakes.owl', false, false, true).
:- rdf_db:rdf_register_ns(ehow, 'http://knowrob.org/kb/ehow_input.owl#', [keep(true)]).


% motion constraint specs:
:- owl_parser:owl_parse('package://knowrob_motion_constraints/owl/pancake-making-constr.owl').

:- rdf_db:rdf_register_ns(constr, 'http://knowrob.org/kb/motion-constraints.owl#', [keep(true)]).
:- rdf_db:rdf_register_ns(pancake_constr, 'http://knowrob.org/kb/pancake-making-constr.owl#', [keep(true)]).

% spatula properties
:- owl_parser:owl_parse('package://knowrob_motion_constraints/owl/spatula-features.owl').
:- rdf_db:rdf_register_ns(spatula, 'http://knowrob.org/kb/spatula-features.owl#', [keep(true)]).


