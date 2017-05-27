//Tiago Henrique Do Couto
//Caique Souza
public class AnSintatico {
	private AnLexico lexico;
	private Token bufferToken;

	public AnSintatico(String filename) {
		lexico = new AnLexico(filename);
	}

	public void start() {
		processaS();
		// TabSymbols.getInstance().printTable();
		// ErrorHandler.getInstance().printErros();
	}

	//program id term BLOCO end_prog term
	private void processaS() {
		Token t = lexico.nextToken();
		if (t.getTokenCode() == TokenID.PROGRAM) {
			// TODO valida token
			t = lexico.nextToken();
			if (t.getTokenCode() == TokenID.ID) {
				// TODO valida token
				t = lexico.nextToken();
				if (t.getTokenCode() == TokenID.TERM) {
					// TODO valida token
					processaBLOCO();
					t = lexico.nextToken();
					if (t.getTokenCode() == TokenID.END_PROG) {
						// TODO valida token
						t = lexico.nextToken();
						if (t.getTokenCode() == TokenID.TERM) {
							// TODO valida token
						} else {
							// TODO tratar erro
						}
					} else {
						// TODO tratar erro
					}
				} else {
					// TODO tratar erro
				}
			} else {
				// TODO tratar erro
			}
		} else {
			// TODO tratar erro
		}
	}

	// begin CMDS end
	// CMD
	private void processaBLOCO() {
		Token t = lexico.nextToken();
		if (t.getTokenCode() == TokenID.BEGIN) {
			// TODO valida token
			processaCMDS();
			t = lexico.nextToken();
			if (t.getTokenCode() == TokenID.END) {
				// TODO valida token
			} else {
				// TODO tratar erro
			}
		} else {
			processaCMD();
		}
	}

	// DECL | COND | REP | ATRIB
	private void processaCMD() {
		Token t = lexico.nextToken();
		bufferToken = t;
		switch (t.getTokenCode()) {
		case WHILE:
			processaREP();
			break;
		case FOR:
			processaREP();
			break;
		case DECLARE:
			processaDECL();
			break;
		case ID:
			processaATRIB();
			break;
		case IF:
			processaCOND();
			break;
		default:
			//TODO ERROR
			break;
		}
	}

	// if l_par EXP_L r_par then BLOCO CNDB
	private void processaCOND() {
		Token t;
		if (bufferToken != null) {
			t = bufferToken;
			bufferToken = null;
		} else {
			t = lexico.nextToken();
		}
		if (t.getTokenCode() == TokenID.IF) {
			// TODO valida token
			t = lexico.nextToken();
			if (t.getTokenCode() == TokenID.L_PAR) {
				// TODO valida token
				processaEXP_L();
				t = lexico.nextToken();
				if (t.getTokenCode() == TokenID.R_PAR) {
					// TODO valida token
					t = lexico.nextToken();
					if (t.getTokenCode() == TokenID.THEN) {
						// TODO valida token
						processaBLOCO();
						processaCNDB();
					}else{
						//TODO error
					}
				}else{
					//TODO error
				}
			}else{
				//TODO error
			}
		}else{
			//TODO error
		}
	}
	
	//while	id 	for	else BLOCO	if	declare end	end_prog 
	private void processaCNDB() {
		Token t = lexico.nextToken();
		switch(t.getTokenCode()){
		case ELSE:
			//TODO valida token
			t = lexico.nextToken();
			processaBLOCO();
			break;
		case WHILE:
			//TODO valida token
			break;
		case ID:
			//TODO valida token
			break;
		case FOR:
			//TODO valida token
			break;
		case IF:
			//TODO valida token
			break;
		case DECLARE:
			//TODO valida token
			break;
		case END:
			//TODO valida token
			break;
		case END_PROG:
			//TODO valida token
			break;
		default:
			//TODO error
			break;
		}

	}
	
	//id attrib_op ATRIB2 term
	private void processaATRIB() {
		Token t;
		if (bufferToken != null) {
			t = bufferToken;
			bufferToken = null;
		} else {
			t = lexico.nextToken();
		}
		if (t.getTokenCode() == TokenID.ID){
			//TODO valida token
			t = lexico.nextToken();
			if (t.getTokenCode() == TokenID.ATTRIB_OP){
				//TODO valida token
				t = lexico.nextToken();
				processaATRIB2();
				t = lexico.nextToken();
				if (t.getTokenCode() == TokenID.TERM){
					//TODO valida token
				}else{
					//TODO error
				}
			}else{
				//TODO error
			}
		}else{
			//TODO error
		}
	}

	private void processaATRIB2() {
		// TODO Auto-generated method stub
		
	}

	private void processaDECL() {
		Token t;
		if (bufferToken != null) {
			t = bufferToken;
			bufferToken = null;
		} else {
			t = lexico.nextToken();
		}
	}

	private void processaREP() {
		Token t;
		if (bufferToken != null) {
			t = bufferToken;
			bufferToken = null;
		} else {
			t = lexico.nextToken();
		}
		if (t.getTokenCode() == TokenID.FOR) {
			if (bufferToken == null) {
				bufferToken = t;
			}
			processaREPF();
		} else if (t.getTokenCode() == TokenID.WHILE) {
			if (bufferToken == null) {
				bufferToken = t;
			}
			processaREPW();
		} else {
			// TODO ERROR
		}
	}

	// while l_par EXP_L r_par BLOCO
	private void processaREPW() {
		Token t;
		if (bufferToken == null) {
			t = lexico.nextToken();
		} else {
			t = bufferToken;
			bufferToken = null;
		}
		if (t.getTokenCode() == TokenID.WHILE) {
			// TODO valida token
			t = lexico.nextToken();
			if (t.getTokenCode() == TokenID.L_PAR) {
				// TODO valida token
				processaEXP_L();
				t = lexico.nextToken();
				if (t.getTokenCode() == TokenID.R_PAR) {
					// TODO valida token
					processaBLOCO();
				} else {
					// TODO error
				}
			} else {
				// TODO error
			}
		} else {
			// TODO error
		}
	}

	private void processaEXP_L() {
		// TODO Auto-generated method stub

	}

	private void processaREPF() {
		Token t;
		if (bufferToken == null) {
			t = lexico.nextToken();
		} else {
			t = bufferToken;
			bufferToken = null;
		}
	}

	private void processaCMDS() {
		Token t = lexico.nextToken();
		if (t.getTokenCode() == TokenID.DECLARE) {
			// TODO valida toke
		} else if (t.getTokenCode() == TokenID.IF) {

		} else if (t.getTokenCode() == TokenID.ID) {

		}
	}

}
