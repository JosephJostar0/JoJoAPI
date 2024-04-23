import { PageContainer } from '@ant-design/pro-components';
import '@umijs/max';
import React, { useEffect, useState } from 'react';
import ReactECharts from 'echarts-for-react';

/**
 * 接口分析
 * @constructor
 */
const InterfaceAnalysis: React.FC = () => {
  // 存储数据的状态
  const [data, setData] = useState([]);
  // 控制加载状态的状态，默认加载中(true)
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // todo 从远程获取数据
  },[])
  
  // ECharts图表的配置选项
  const option = {
    title: {
      text: '调用次数最多的接口top3',
      subtext: '',
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: [
          { value: 1048, name: '随机邮箱' },
          { value: 735, name: '点歌' },
          { value: 580, name: '文本转语音' },
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  }
  return (
  <PageContainer>
    {/* 使用 ReactECharts 组件，传入图表配置 */}
    <ReactECharts loadingOption={{
      // 控制加载状态
      showLoading: loading
    }}
    option={option} />
  </PageContainer>
  );
};
export default InterfaceAnalysis;
