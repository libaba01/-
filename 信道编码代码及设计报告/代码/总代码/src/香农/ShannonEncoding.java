package ��ũ;

import java.util.*;

import �ŵ�����.fetch_text;

public class ShannonEncoding {
	
    public String line ;
    public ShannonEncoding(String content) {
		// TODO Auto-generated constructor stub
    	this.line=content;
	}
	List<Bean> beans = new ArrayList<>();
    double averageCodingLength;
    double averageSelfInformation;
    //�������
    public void getProbability(){
        //����HashMap���ϣ�����character��ֵ��Integer
        Map<Character, Integer> hm = new HashMap();
        //double probability = 1.0/line.length();
        //ѭ�������ַ������õ�ÿ���ַ�
        for(int i = 0; i < line.length() ; i++) {
            //ͨ��charAt���������ַ���������ֵ����Ϊ����ӵ�HashMap������
            char key = line.charAt(i);
            //ʹ��HashMap���ϵ�get�������Լ����еļ����ַ��������ж�
            //����Integer����洢ֵ
            Integer value = hm.get(key);
            //����ֵΪ�գ����ַ���Ϊ����1��Ϊ�洢ֵ
            if (value == null) {
                hm.put(key, 1);
            } else {
                //����ֵ��Ϊ�գ�˵�����ַ��ڼ����г��ֹ������ַ���Ϊ����ֵ��һ
                // ���´洢��(�ַ�)�Ͷ�Ӧ��ֵ
                value++;
                hm.put(key, value);
            }
        }
        List<Map.Entry<Character, Integer>> infoIds = new ArrayList<Map.Entry<Character, Integer>>(hm.entrySet());
        //����value����
        Collections.sort(infoIds, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        //�����
        for (int i = 0; i < infoIds.size(); i++) {
            String s = infoIds.get(i).toString();
            String[] kv = s.split("=");
            Bean bean = new Bean(kv[0],Integer.parseInt(kv[1]));
            beans.add(bean);
        }
        //�������
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            bean.setP((bean.getCount()+0.0)/line.length());
        }
        //��������Ϣ
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            bean.set_logp(-(Math.log(bean.getP())/Math.log(2)));
        }
        //��Ӧ�볤
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            bean.setCodingLength((int)(bean.get_logp()+0.9999999999999));
        }
        //�ۼƸ���
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            double _p = 0;
            for (int j = 0;j < i;j++){
                Bean bean1 =beans.get(j);
                _p += bean1.getP();
            }
            bean.setCumulativeprobability(_p);
        }
        //ʮ����ת������
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            StringBuilder sb = new StringBuilder("");
            double leijigailv = bean.getCumulativeprobability();
            for (int j = 0; j < bean.getCodingLength();j++){
                sb.append((int)(leijigailv*2));
                leijigailv=2*leijigailv-(int)(leijigailv*2);
            }
            bean.setCodeLetter(String.valueOf(sb));
        }
    }
    //ƽ���볤
    public double averageCodingLength(){
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            averageCodingLength+=bean.getCodingLength()*bean.getP();
        }
        return averageCodingLength;
    }
    //����Ч��
    public double codeEfficiency(){
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
            averageSelfInformation+=bean.get_logp()*bean.getP();
        }
        return averageSelfInformation/this.averageCodingLength;
    }
    //����
    //����һ�����Ͻ�������̵����ݴ��뼯��
    public HashMap codeLetter(){
    	HashMap<String,String> map = new HashMap<String,String>() ;
        for (int i = 0; i < beans.size();i++){
            Bean bean = beans.get(i);
//            System.out.println(bean.getKey() + "����" + bean.getCodeLetter());
            map.put(bean.getKey(), bean.getCodeLetter());
        }
        
        return map;
    }
}
