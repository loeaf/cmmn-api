import subprocess, re
import sys

import time

loginInfo = [
    {'system':'testmq',
     'ip':'172.50.17.241',
     'port':'22',
     'id':'osadm'},
    {'system':'eventwas3',
     'ip':'172.50.17.203',
     'port':'22',
     'id':'osadm'},
    {'system':'hadop',
     'ip':'172.50.17.228',
     'port':'22',
     'id':'osadm'},
    {'system':'hadop-master',
     'ip':'172.50.17.250',
     'port':'22',
     'id':'osadm'}
]
def getData():
    print(loginInfo[1]['system'])
def main():
    resultString = ''
    for inst in loginInfo:
        '''
        아래 기능이 실행하기 전 ssh-copy-id를 통해서 ssh값을 타 서버로 복하사여야함...
        ssh-keygen -t rsa
        ssh-copy-id -i osadm@172.50.17.228
        비번 : P@ssw0rd
        '''
        start_time = time.time()
        output = subprocess.check_output(['ssh', inst['id']+'@'+inst['ip'], 'top', '-bn1', '-o', '%MEM'])
        match = re.match(r'^[\w\W]*?\n( +PID.*COMMAND)\n([\w\W]*)', output.decode())
        matchs = match[0].split('\n')
        result2 = matchs[2].split(',')
        result3 = matchs[3].split(',')
        output2 = subprocess.check_output(['ssh', inst['id']+'@'+inst['ip'],'df', '-h']).decode()
        outputSplit = output2.split('\n')
        str = '|'.join(i for i in outputSplit[0].split(' ') if i)
        hdResult = ''
        for obj in outputSplit:
            str = '|'.join(i for i in obj.split(' ') if i)
            if len(str) > 5:
                if str.split('|')[5] == '/':
                    hdResult = str
        # print('ssh {}'.format(time.time() - start_time))
        '''
        기관,CPU|전체|사용,MEM|전체|사용|,마운트대상|전체|사용|여유|비율
        '''
        cpuResult = 'CPU|100|'+re.findall('\d.\d+', result2[0])[0]
        memResult = 'MEM|'+re.findall('\d.\d+', result3[0])[0] + '|' + re.findall('\d.\d+', result3[1])[0]
        resultString += inst['system']+','+cpuResult+','+memResult+','+hdResult + ':'
    print(resultString)
    sys.exit()

main()
# getData()