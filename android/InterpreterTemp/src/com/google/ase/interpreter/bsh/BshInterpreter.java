/*
 * Copyright (C) 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.ase.interpreter.bsh;

import com.google.ase.interpreter.DefaultInterpreter;
import com.google.ase.interpreter.InterpreterProcess;
import com.google.ase.language.BeanShellLanguage;

public class BshInterpreter extends DefaultInterpreter {

  private final static String BSH_BIN =
      "dalvikvm -classpath /sdcard/ase/extras/bsh/bsh-2.0b4-dx.jar bsh.Interpreter";

  public BshInterpreter() {
    super(new BeanShellLanguage());
  }

  @Override
  public String getExtension() {
    return ".bsh";
  }

  @Override
  public String getName() {
    return "bsh";
  }

  @Override
  public String getNiceName() {
    return "BeanShell 2.0b4";
  }

  @Override
  public InterpreterProcess buildProcess(String scriptName, int port) {
    return new BshInterpreterProcess(scriptName, port);
  }

  public boolean hasInterpreterArchive() {
    return false;
  }

  public boolean hasExtrasArchive() {
    return true;
  }

  public boolean hasScriptsArchive() {
    return true;
  }

  @Override
  public String getBinary() {
    return BSH_BIN;
  }

  @Override
  public int getVersion() {
    return 1;
  }

}