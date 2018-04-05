#pragma once
#include <numeric>
#include <cassert>
#include <functional>
#include <vector>
#include <algorithm>
#include <iostream>

namespace nowcoder
{
    namespace solution006
    {
        struct machine
        {
            int max_time;
            int max_level;
        };
        struct task
        {
            int time;
            int level;
        };
        size_t task_count = 0;
        size_t task_value = 0;
        void dfs(std::vector<machine>& mach, std::vector<task>& task, std::vector<bool>& task_marked)
        {
            
            for (auto i = 0; i != task_marked.size(); ++i)
            {
                if (task_marked[i])
                    continue;
                //if(task[i].time>)
                task_marked[i] = true;
                dfs(mach, task, task_marked);
                task_marked[i] = false;
            }
        }
        void test()
        {
            size_t n, m;
            while (std::cin >> n >> m)
            {
                task_count = 0;
                task_value = 0;
                std::vector<machine> mach(n);
                std::vector<task> task(m);
                std::vector<int> task_index(n, 0);
                for (size_t i = 0; i != n; ++i)
                    std::cin >> mach[i].max_time >> mach[i].max_level;
                for (size_t i = 0; i != m; ++i)
                    std::cin >> task[i].time >> task[i].level;
                for (auto i = std::min(n, m); i > 0; --i)
                {
                    task_index.assign(n, 0);
                    for (auto j = 1; j <= i; ++j)
                        task_index[j - 1] = j;
                    std::sort(task_index.begin(), task_index.end());
                    do
                    {
                        size_t count = 0;
                        size_t profit = 0;
                        for (auto k = 0; k != task_index.size(); ++k)
                        {
                            auto index = task_index[k];
                            if (index == 0)
                                continue;
                            if (mach[k].max_time < task[index].time || mach[k].max_level < task[index].level)
                                continue;
                            ++count;
                            profit += 200 * task[index].time + 3 * task[index].level;
                        }
                        if (count > task_count&&profit > task_value)
                        {
                            task_count = count;
                            task_value = profit;
                        }
                    } while (std::next_permutation(task_index.begin(), task_index.end()));
                }
                std::cout << task_count << " " << task_value << "\n";
/*                std::vector<bool> task_marked(m, false);
                for (size_t i = 0; i != n; ++i)
                    std::cin >> mach[i].max_time >> mach[i].max_level;
                for (size_t i = 0; i != m; ++i)
                    std::cin >> task[i].time >> task[i].level;
                for (auto i = 0; i != task_marked.size(); ++i)
                {
                    if (task_marked[i])
                        continue;
                    task_marked[i] = true;
                    dfs(mach, task, task_marked);
                    task_marked[i] = false;
                }*/
            }
        }
    }
}