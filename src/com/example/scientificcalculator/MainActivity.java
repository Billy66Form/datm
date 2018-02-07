package com.example.scientificcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView;
    boolean hyperbolic = false;
    String expression="";
    String text="";
    Double initial=0.0;
    Double aux=0.0;
    Double result=0.0;
    Double memoryNumber=0.0;
    boolean dotActive=false;
    boolean percentActive=false;
    boolean paranthesisOpen = false;
    boolean shiftActive=false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView2);
        textView.setText("0");

        Button shift = (Button) findViewById(R.id.button);
        Button drg = (Button) findViewById(R.id.button2);
        Button mclear = (Button) findViewById(R.id.button3);
        Button mset = (Button) findViewById(R.id.button4);
        Button mplus = (Button) findViewById(R.id.button6);
        Button mrecall = (Button) findViewById(R.id.button5);
        // computational functions
        Button hyp = (Button) findViewById(R.id.button7);
        Button ypowx = (Button) findViewById(R.id.button13);
        Button log = (Button) findViewById(R.id.button12);
        Button sin = (Button) findViewById(R.id.button8);
        Button cos = (Button) findViewById(R.id.button9);
        Button tan = (Button) findViewById(R.id.button10);
        Button ln = (Button) findViewById(R.id.button11);
        Button sqrt= (Button) findViewById(R.id.button14);
        Button square= (Button) findViewById(R.id.button15);
        Button exp = (Button) findViewById(R.id.button16);
        Button ac = (Button) findViewById(R.id.button25);
        Button delete = (Button) findViewById(R.id.button32);
        Button equals = (Button) findViewById(R.id.button26);
        Button leftParanthesis = (Button) findViewById(R.id.button17);
        Button rightParanthesis = (Button) findViewById(R.id.button18);
        Button signChanger = (Button) findViewById(R.id.button41);
        Button dot = (Button) findViewById(R.id.button43);
        Button percent = (Button) findViewById(R.id.button40);
        
        //basic operations
        Button plus = (Button) findViewById(R.id.button34);
        Button minus = (Button) findViewById(R.id.button35);
        Button multiply = (Button) findViewById(R.id.button29);
        Button divide = (Button) findViewById(R.id.button33);

        //numbers and basic operations
        Button one = (Button) findViewById((R.id.button30));
        Button two = (Button) findViewById(R.id.button42);
        Button three = (Button) findViewById(R.id.button21);
        Button four = (Button) findViewById(R.id.button20);
        Button five = (Button) findViewById(R.id.button31);
        Button six = (Button) findViewById(R.id.button23);
        Button seven = (Button) findViewById(R.id.button19);
        Button eight = (Button) findViewById(R.id.button28);
        Button nine = (Button) findViewById(R.id.button24);
        Button zero = (Button) findViewById((R.id.button22));
        
        shift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	aux=readText();
                textView.setText("0");
            	shiftActive=true;
            }
        });
        
        drg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(shiftActive){
            		if(textView.getText().equals("1")) {
            			writeText(Math.toRadians(aux));
            		}
            		if(textView.getText().equals("2")){
            			writeText(Math.toDegrees(aux));
            		}
            	}
            	shiftActive=false;
            }
        });
        
        mset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	try{
            		memoryNumber=readText();
            	}
            	catch (Exception e){
            		Log.e("Problem", e.getMessage());
            	}
            }
        });
        
        mclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	memoryNumber=0.0;
            }
        });
        
        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	try{
            		memoryNumber=memoryNumber+readText();
            	}
            	catch (Exception e){
            		Log.e("Problem", e.getMessage());
            	}
            }
        });
        
        mrecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	writeText(memoryNumber);
            }
        });
        
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(2);
            		
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	handleNumbers(0);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	result=Math.pow(readText(),2);
                writeText(result);
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	result=Math.pow(readText(),0.5);
                writeText(result);
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=Math.log(readText());
                writeText(result);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Double radians = Math.toRadians(readText());
            	if(hyperbolic){
            		result=Math.tanh(radians);
            	}
            	else{
            		result=Math.tan(radians);
            	}
                writeText(result);
                hyperbolic = false;
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Double radians = Math.toRadians(readText());
            	if(hyperbolic){
            		result=Math.sinh(radians);
            	}
            	else{
            		result=Math.sin(radians);
            	}
                writeText(result);
                hyperbolic = false;
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           
                Double radians = Math.toRadians(readText());
                if(hyperbolic){
            		result=Math.cosh(radians);
            	}
            	else{
            		result=Math.cos(radians);
            	}
                writeText(result);    
                hyperbolic = false;
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	result=Math.log10(readText());
                writeText(result);
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	result=Math.exp(readText());
                writeText(result);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0");
                dotActive=false;
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	String a = textView.getText().toString();
            	if(a.length()>1 && (a.substring(a.length()-1)!=".")){
            		textView.setText(a.substring(0, a.length()-1));
            	}
            }
        });
        signChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	result=-readText();
                writeText(result);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { 
            	switch(expression) {
            	case "plus": 
            		if(!percentActive){
            			result=aux+readText();
            		}
            		else {
            			result=aux+aux*readText()/100;
            		}
                	writeText(result);
                	break;
            	case "minus":
            		if(!percentActive){
            			result=aux-readText();
            		}
            		else {
            			result=aux-aux*readText()/100;
            		}
                	writeText(result);
                	break;
            	case "multiply":
            		result=aux*readText();
                	writeText(result);
                	break;
            	case "divide":
            		result=aux/readText();
                	writeText(result);
                	break;
            	case "ypowx":
            		result=Math.pow(aux,readText());
                	writeText(result);
                break;
            	} 	
         
                expression="";
                initial=0.0;
                aux=0.0;
                result=0.0;
                percentActive=false;
                dotActive=false;

            }
        });

        leftParanthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { 
            	paranthesisOpen = true; 
            	textView.setText("(");
         
            }
        });
        
        rightParanthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { 
            	try{
            	if(paranthesisOpen){
            		String complex = textView.getText().toString();
            		complex=complex.substring(1, complex.length());
            		result=eval(complex);
            		writeText(result);
            		Log.i("Value:", result.toString());
            		paranthesisOpen=false;
            		}
            	}
            	catch(Exception e) {
            	Log.e("Problem", e.getMessage());
            	}
            }
        });
        
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(!paranthesisOpen){
            		waitToTheNextOperand("plus");
            		dotActive=false;
            	}
            	else{
            		textView.setText(textView.getText()+"+");
            	}
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(!paranthesisOpen){
            		waitToTheNextOperand("minus");
            		dotActive=false;
            	}
            	else{
            		textView.setText(textView.getText()+"-");
            	}
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(!paranthesisOpen){
            		waitToTheNextOperand("multiply");
            		dotActive=false;
            	}
            	else{
            		textView.setText(textView.getText()+"*");
            	}
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(!paranthesisOpen){
            		waitToTheNextOperand("divide");
            		dotActive=false;
            	}
            	else{
            		textView.setText(textView.getText()+"/");
            	}
            }
        });
        ypowx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	waitToTheNextOperand("ypowx");
            	dotActive=false;
            }
        });
        hyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	hyperbolic=true;
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	dotActive=true;
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	percentActive=true;
            }
        });
        
    }
    
    public Double readText() {
    	try{
    		String a = textView.getText().toString();
    		initial = Double.parseDouble(a);
    		return initial;
    	}
    	catch (Exception e){
    		textView.setText("0");
    		paranthesisOpen=false;
    		return 0.0;
    	}
		
    }
    
    public void writeText (Double result) {
    	Integer integerResult;
    	String s;
    	if(result%1==0){
    		integerResult=result.intValue();
    		s=integerResult.toString();
    	}
    	else{
    		s = result.toString();
    	}
        textView.setText(s.substring(0, Math.min(s.length(), 13)));
    }
    
    public void waitToTheNextOperand(String operationExpression){
    	aux=readText();
        expression=operationExpression;
        textView.setText("0");
    }
    
    public void handleNumbers(int number){
    		if(!paranthesisOpen){
        	initial=readText();
    		text=initial.toString();
        		if(!dotActive){
        			result=10*readText()+number;
        		}
        		else{
        			if(initial%1==0){
        				result=initial+number*Math.pow(10, -1);
        			}
        			else {
        				text=text+String.valueOf(number);
        				result = Double.parseDouble(text);
        			}           		
        		}
        		writeText(result);
        	}
    		else{
        		textView.setText(textView.getText()+String.valueOf(number));
        	}
    }
    
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
