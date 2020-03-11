package pk.edu.pucit.calculator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {
    private TextView tv_equation,tv_result,AC,divide,multiply,subtract,add,seven,eight,nine,zero,zero2,four,five,six,one,two,three,decimal,del,mode,equal;
    private String process;
    private boolean lastNumeric,lastDot;
    private  int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        zero2=findViewById(R.id.zero2);

        add=findViewById(R.id.add);
        subtract=findViewById(R.id.subtract);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        mode=findViewById(R.id.mode);

        decimal=findViewById(R.id.decimal);
        del=findViewById(R.id.del);
        equal=findViewById(R.id.equal);
        AC=findViewById(R.id.AC);

        tv_equation=findViewById(R.id.tv_equation);
        tv_result=findViewById(R.id.tv_result);

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_equation.setText("");
                tv_result.setText("");
                count=0;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"0");
            }
        });
        zero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"00");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                tv_equation.setText(process+"9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tv_equation.getText().toString();
                if(count==0) {
                    tv_equation.setText(process + ".");
                    lastDot = true;
                    lastNumeric = false;
                    count = 1;
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqual();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                int length = process.length() - 1;
                if (length + 1 > 0) {
                    char last = process.charAt(length);
                    if (last == '+' || last == '-' || last == '*' || last == '/' || last == '%') {
                        process = process.substring(0, length);
                        tv_equation.setText(process);
                    }
                    tv_equation.setText(process + "+");
                    lastDot = false;
                    lastNumeric = true;
                    count = 0;
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                int length = process.length() - 1;
                if (length + 1 > 0) {
                    char last = process.charAt(length);
                    if (last == '+' || last == '-' || last == '*' || last == '/' || last == '%') {
                        process = process.substring(0, length);
                        tv_equation.setText(process);
                    }
                    tv_equation.setText(process + "-");
                    lastDot = false;
                    lastNumeric = true;
                    count = 0;

                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                int length = process.length() - 1;
                if (length + 1 > 0) {
                    char last = process.charAt(length);
                    if (last == '+' || last == '-' || last == '*' || last == '/' || last == '%') {
                        process = process.substring(0, length);
                        tv_equation.setText(process);
                    }
                    tv_equation.setText(process + "*");
                    lastDot = false;
                    lastNumeric = true;
                    count = 0;

                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                int length = process.length() - 1;
                if (length + 1 > 0) {
                    char last = process.charAt(length);
                    if (last == '+' || last == '-' || last == '*' || last == '/' || last == '%') {
                        process = process.substring(0, length);
                        tv_equation.setText(process);
                    }
                    tv_equation.setText(process + "/");
                    lastDot = false;
                    lastNumeric = true;
                    count = 0;

                }
            }
        });

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                int length = process.length() - 1;
                if (length + 1 > 0) {
                    char last = process.charAt(length);
                    if (last == '+' || last == '-' || last == '*' || last == '/' || last == '%') {
                        process = process.substring(0, length);
                        tv_equation.setText(process);
                    }
                    tv_equation.setText(process + "%");
                    lastDot = false;
                    lastNumeric = true;
                    count = 0;

                }
            }
        });
    }
    private void onEqual() {
        String txt = tv_equation.getText().toString();
        if (txt != "") {
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                double result = expression.evaluate();
                tv_result.setText(Double.toString(result));
                //   lastDot = true;
            } catch (ArithmeticException ex) {
                tv_result.setText("Error");
            }
        }
    }
        private void del()
        {
            String s=tv_equation.getText().toString();
            int length=s.length();
            if(length!=0) {
                int l=length-1;
                char last=s.charAt(l);
                s = s.substring(0, s.length() - 1);
                tv_equation.setText(s);
                if(last=='.')
                {
                    count=0;
                }
            }
        }
}
