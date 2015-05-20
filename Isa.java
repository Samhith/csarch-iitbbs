import java.lang.*;
import java.io.*;
public class Isa{
	String assembler(String inst){
		String init = new String();
		String op = inst.substring(0,3);
		String opcode = new String();
		switch (op){
			case "adr" : opcode = "00001";
						 break;
			case "adi" : opcode = "00010";
						 break;
			case "mlr" : opcode = "00011";
						 break;
			case "mli" : opcode = "00100";
						 break;
			case "anr" : opcode = "00101";
						 break;
			case "ani" : opcode = "00110";
						 break;
			case "orr" : opcode = "00111";
						 break;
			case "ori" : opcode = "01000";
						 break;
			case "ldr" : opcode = "01001";
						 break;
			case "ldi" : opcode = "01010";
						 break;
			case "ldd" : opcode = "01011";
						 break;
			case "lda" : opcode = "01100";
						 break;
			case "str" : opcode = "01101";
						 break;
			case "sti" : opcode = "01110";
						 break;
			case "std" : opcode = "01111";
						 break;
			case "sta" : opcode = "10000";
						 break;
			case "cmp" : opcode = "10001";
						 break;
			case "bie" : opcode = "10010";
						 break;
			case "bil" : opcode = "10011";
						 break;
			case "big" : opcode = "10100";
						 break;
			case "hal" : opcode = "10101";
						 break;
			case "inc" : opcode = "10110";
						 break;
			case "dec" : opcode = "10111";
						 break;
			case "mov" : opcode = "11000";
						 break;
			case "not" : opcode = "11001";
						 break;
			case "nti" : opcode = "11010";
						 break;

		}

		String rd = inst.substring(3,4);
		String rs = inst.substring(4,5);
		String rt = inst.substring(5,6);
		int rdi = Integer.parseInt(rd);
		int rsi = Integer.parseInt(rs);
		int rti = Integer.parseInt(rt);
		String rdb=Integer.toBinaryString(rdi);
		char[] rdc = new char[3];
		for (int n=0;n<3-rdb.length();n++ ) {
			rdc[n]='0';
		}
		int i=0;
		for (int n=3-rdb.length();n<3 ;n++ ) {
			rdc[n]=rdb.charAt(i);
			i++;
		}
		rdb = new String(rdc);

		String rsb=Integer.toBinaryString(rsi);
		char[] rsc = new char[3];
		for (int n=0;n<3-rsb.length();n++ ) {
			rsc[n]='0';
		}
		int l=0;
		for (int n=3-rsb.length();n<3 ;n++ ) {
			rsc[n]=rsb.charAt(l);
			l++;
		}
		rsb = new String(rsc);

		String rtb=Integer.toBinaryString(rti);
		char[] rtc = new char[3];
		for (int n=0;n<3-rtb.length();n++ ) {
			rtc[n]='0';
		}
		int j=0;
		for (int n=3-rtb.length();n<3 ;n++ ) {
			rtc[n]=rtb.charAt(j);
			j++;
		}
		rtb = new String(rtc);

		init = opcode;
		//return rsb;
		return ((opcode.concat(rdb)).concat(rsb)).concat(rtb) ;

	}	

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("input.txt");
		FileOutputStream fos = new FileOutputStream("output.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		Isa b = new Isa();
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
 			    String line;
    			while ((line = br.readLine()) != null) {
       			String ass = b.assembler(line);
       			bw.write(ass+"\n");
       			bw.newLine();
    		    }
    		    bw.close();
        }

        catch(Exception e){
        	System.out.println("error");
        }
		
	}
}