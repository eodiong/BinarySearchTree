package volunteer.softwares.com.myapplication;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private TextView numElementsTV,elements;
    private BinaryTree bt;
    LinearLayout layoutTest;
    TextView tv[]=new TextView[1000];
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get our widgets from our layout
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.numElementsTV = (TextView)this.findViewById(R.id.numElementsTV);
        this.elements = (TextView)this.findViewById(R.id.elements);
        this.layoutTest=(LinearLayout)this.findViewById(R.id.layoutTest);

        //create our binaryTree
        this.bt = new BinaryTree();

        this.updateTreeCount();
    }

    private void updateTreeCount()
    {
        this.numElementsTV.setText("" + this.bt.getCount());
    }

    public void addToTreeButtonPressed(View v)
    {
        if(this.inputET.getText().length() > 0)
        {
            int payload = Integer.parseInt(this.inputET.getText().toString());
            this.bt.add(payload);
            this.updateTreeCount();
            inputET.setText("");
        }
    }

    public void preorder(View view)
    {
        num=0;
        if(layoutTest.getChildCount()>0)
        layoutTest.removeAllViews();
        elements.setText("");
       traversePre(bt.getRoot());
    }

    public void inorder(View view)
    {
        num=0;
        if(layoutTest.getChildCount()>0)
        layoutTest.removeAllViews();
        elements.setText("");
        traverseIn(bt.getRoot());
    }

    public void postorder(View view)
    {
        num=0;
        if(layoutTest.getChildCount()>0)
        layoutTest.removeAllViews();
        elements.setText("");
        traversePost(bt.getRoot());
    }

    void traversePre(Node root)
    {
       if (root==null)
             return;

        tv[num] = new TextView(MainActivity.this);
        tv[num].setText("" + root.getPayload());
        layoutTest.addView(tv[num]);
        num+=1;

        traversePre(root.getLeftChild());
        traversePre(root.getRightChild());


    }

    void traverseIn(Node root)
    {
        if (root==null)
            return;
            traverseIn(root.getLeftChild());

        tv[num] = new TextView(MainActivity.this);
        tv[num].setText("" + root.getPayload());
        layoutTest.addView(tv[num]);
        num+=1;

        traverseIn(root.getRightChild());


    }

    void traversePost(Node root)
    {
        if (root==null)
            return;
        traversePost(root.getLeftChild());
        traversePost(root.getRightChild());

        tv[num] = new TextView(MainActivity.this);
        tv[num].setText("" + root.getPayload());
        layoutTest.addView(tv[num]);
        num+=1;


    }
}
